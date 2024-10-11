package com.rajat.elevatorsystem.Controllers;

import com.rajat.elevatorsystem.models.DIRECTION;
import com.rajat.elevatorsystem.models.Elevator;
import com.rajat.elevatorsystem.models.ElevatorStatus;
import com.rajat.elevatorsystem.models.Request;
import com.rajat.elevatorsystem.strategies.OptimalElevatorStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    List<Elevator> elevatorList;
    OptimalElevatorStrategy optimalElevatorStrategy;
    public ElevatorController(int numberOfElevators, int capacity, OptimalElevatorStrategy optimalElevatorStrategy) {
        this.elevatorList = new ArrayList<>();
        this.optimalElevatorStrategy = optimalElevatorStrategy;
        for(int i=0;i<numberOfElevators;i++){
            final Elevator elevator = new Elevator(i+1,capacity);
            elevatorList.add(elevator);
            new Thread(elevator::run).start();
        }
    }
    public void requestElevator(int srcFloor,int destFloor){
        Elevator elevator = optimalElevatorStrategy.findOptimalElevator(elevatorList,srcFloor,destFloor);
        elevator.addRequest(new Request(srcFloor,destFloor));
    }
}
