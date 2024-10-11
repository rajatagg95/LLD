package com.rajat.elevatorsystem;

import com.rajat.elevatorsystem.Controllers.ElevatorController;
import com.rajat.elevatorsystem.strategies.impl.ShortestWaitingTimeStrategy;

public class ElevatorSystem {
    public static void main(String[] args) throws InterruptedException {

        int numberOfElevators = 3;   // Number of elevators in the system
        int elevatorCapacity = 10;   // Capacity of each elevator

        // Initialize the Elevator Manager with the specified number of elevators and capacity
        ElevatorController elevatorController = new ElevatorController(numberOfElevators, elevatorCapacity,new ShortestWaitingTimeStrategy());

        // Simulate various elevator requests
        elevatorController.requestElevator(0, 5);   // Request from floor 0 to floor 5
        elevatorController.requestElevator(3, 9);   // Request from floor 3 to floor 9

        Thread.sleep(2000);

        elevatorController.requestElevator(10, 2);  // Request from floor 10 to floor 2

        Thread.sleep(2000);


        elevatorController.requestElevator(7, 12);  // Request from floor 7 to floor 12
        elevatorController.requestElevator(4, 0);   // Request from floor 4 to ground floor

    }
}