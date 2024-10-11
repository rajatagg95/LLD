package com.rajat.elevatorsystem.strategies.impl;

import com.rajat.elevatorsystem.models.DIRECTION;
import com.rajat.elevatorsystem.models.Elevator;
import com.rajat.elevatorsystem.models.ElevatorStatus;
import com.rajat.elevatorsystem.strategies.OptimalElevatorStrategy;

import java.util.List;

public class ShortestWaitingTimeStrategy implements OptimalElevatorStrategy {
    @Override
    public Elevator findOptimalElevator(List<Elevator> elevatorList, int srcFloor, int destFloor) {
        int min = Integer.MAX_VALUE;
        Elevator optimalElevator = elevatorList.get(0);
        for(int i=0;i<elevatorList.size();i++){
            Elevator elevator = elevatorList.get(i);
            if(elevator.getElevatorStatus().equals(ElevatorStatus.OUT_OF_OPERATION))
                continue;
            int currentFloor = elevator.getCurrentFloor();
            int distance = Math.abs(srcFloor - currentFloor);
            System.out.println("Distance for elevator with id " + elevator.getId() +  "  is " + distance + " and current floor " + currentFloor  +   " and direction " + elevator.getDirection() + " and elevator status :" + elevator.getElevatorStatus()+  "  (Thread: " + Thread.currentThread().getName() + ")");
            if( distance < min &&  (elevator.getElevatorStatus() == ElevatorStatus.IDLE || (elevator.getDirection() == DIRECTION.UP && srcFloor >= currentFloor) ||
                    (elevator.getDirection() == DIRECTION.DOWN && srcFloor <= currentFloor))){
                optimalElevator = elevator;
                min = distance;
            }
        }

        // Fallback to any available elevator if no optimal one found
        if (optimalElevator == null) {
            optimalElevator = elevatorList.get(0);
        }
        return optimalElevator;
    }
}
