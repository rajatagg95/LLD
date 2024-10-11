package com.rajat.elevatorsystem.models;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    int id;
    int capacity;
    int currentFloor;
    List<Request> requestList;
    ElevatorStatus elevatorStatus;
    DIRECTION direction;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        requestList = new ArrayList<>();
        elevatorStatus = ElevatorStatus.IDLE;
        currentFloor = 0;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorStatus getElevatorStatus() {
        return elevatorStatus;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public synchronized void addRequest(Request request){
        requestList.add(request);
        System.out.println("Optimal elevator is elevator with id " + id + " for request " + request +  " (Thread: " + Thread.currentThread().getName() + ")");
        System.out.println();
        notifyAll();
    }

    public synchronized void processRequests(){
        while(true){
            while(!requestList.isEmpty()){
                Request request = getNextRequest();
                processRequest(request);
            }
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getId() {
        return id;
    }

    private void processRequest(Request request) {
     if(currentFloor != request.getSrcFloor()){
         moveToFloor(request.getSrcFloor());
     }

     moveToFloor(request.getDestFloor());
     elevatorStatus = ElevatorStatus.IDLE;
     direction = null;
    }


    private void moveToFloor(int targetFloor){

        if(currentFloor < targetFloor){
            direction = DIRECTION.UP;
            elevatorStatus = ElevatorStatus.WORKING;

            for(int i = currentFloor+1; i<=targetFloor;i++){
                try {
                    Thread.sleep(1000); // Simulating elevator movement
                    currentFloor = i;
                    System.out.println("Elevator " + id + " reached floor " + currentFloor + " (Thread: " + Thread.currentThread().getName() + ")");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            direction = DIRECTION.DOWN;
            elevatorStatus = ElevatorStatus.WORKING;
            for(int i = currentFloor-1; i>=targetFloor;i--){
                try {
                    Thread.sleep(1000); // Simulating elevator movement
                    currentFloor = i;
                    System.out.println("Elevator " + id + " reached floor " + currentFloor + " (Thread: " + Thread.currentThread().getName() + ")");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println();
        System.out.println();
    }

    private synchronized Request getNextRequest() {
        while(requestList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return requestList.remove(0);
    }

    public void run() {
        processRequests();
    }
}
