package elevator.system;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ElevatorSystem {
    public static void main(String[] args) throws InterruptedException {

        int numberOfElevators = 3;   // Number of elevators in the system
        int elevatorCapacity = 10;   // Capacity of each elevator

        // Initialize the Elevator Manager with the specified number of elevators and capacity
        ElevatorManager manager = new ElevatorManager(numberOfElevators, elevatorCapacity);

        // Simulate various elevator requests
        manager.requestElevator(0, 5);   // Request from floor 0 to floor 5
        manager.requestElevator(3, 9);   // Request from floor 3 to floor 9

        Thread.sleep(2000);

        manager.requestElevator(10, 2);  // Request from floor 10 to floor 2

        Thread.sleep(2000);


        manager.requestElevator(7, 12);  // Request from floor 7 to floor 12
        manager.requestElevator(4, 0);   // Request from floor 4 to ground floor

    }
}