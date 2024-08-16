package elevator.system;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {
    List<Elevator> elevatorList;
    public ElevatorManager(int numberOfElevators, int capacity) {
        this.elevatorList = new ArrayList<>();
        for(int i=0;i<numberOfElevators;i++){
            final Elevator elevator = new Elevator(i+1,capacity);
            elevatorList.add(elevator);
            new Thread(elevator::run).start();
        }
    }
    public void requestElevator(int srcFloor,int destFloor){
        Elevator elevator = findOptimalElevator(srcFloor,destFloor);
        elevator.addRequest(new Request(srcFloor,destFloor));
    }

    private Elevator findOptimalElevator(int srcFloor,int destFloor) {
        int min = Integer.MAX_VALUE;
        Elevator optimalElevator = elevatorList.get(0);
        for(int i=0;i<elevatorList.size();i++){
            Elevator elevator = elevatorList.get(i);
            if(elevator.elevatorStatus.equals(ElevatorStatus.OUT_OF_OPERATION))
                continue;
            int currentFloor = elevator.getCurrentFloor();
            int distance = Math.abs(srcFloor - currentFloor);
            System.out.println("Distance for elevator with id " + elevator.getId() +  "  is " + distance + " and current floor " + currentFloor  +   " and direction " + elevator.getDirection() + " and elevator status :" + elevator.getElevatorStatus()+  "  (Thread: " + Thread.currentThread().getName() + ")");
            if( distance < min &&  (elevator.getElevatorStatus() == ElevatorStatus.IDLE || (elevator.getDirection() == DIRECTION.UP && srcFloor >= currentFloor) ||
                    (elevator.getDirection() == DIRECTION.DOWN && srcFloor <= currentFloor))){
                System.out.println("in loop Distance for elevator with id " + elevator.getId() +  "  is " + distance + " and current floor " + currentFloor  +   " and direction " + elevator.getDirection() + " and elevator status :" + elevator.getElevatorStatus()+  "  (Thread: " + Thread.currentThread().getName() + ")");
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
