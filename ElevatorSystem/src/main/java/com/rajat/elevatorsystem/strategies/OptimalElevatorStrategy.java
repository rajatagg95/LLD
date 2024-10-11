package com.rajat.elevatorsystem.strategies;

import com.rajat.elevatorsystem.models.Elevator;

import java.util.List;

public interface OptimalElevatorStrategy {

     Elevator findOptimalElevator(List<Elevator> elevatorList, int srcFloor, int destinationFloor);
}
