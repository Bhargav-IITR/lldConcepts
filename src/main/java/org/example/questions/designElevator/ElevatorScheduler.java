package org.example.questions.designElevator;

import org.example.questions.designElevator.enums.Direction;

import java.util.List;

public class ElevatorScheduler {
    private List<ElevatorController> controllers;
    private ElevatorSelectionStrategy strategy;

    public ElevatorScheduler(List <ElevatorController> controllers, ElevatorSelectionStrategy strategy){
        this.controllers = controllers;
        this.strategy = strategy ;
    }
    public void setStrategy(ElevatorSelectionStrategy strategy){this.strategy = strategy ;}

    public ElevatorController assignElevator(int floor, Direction direction){
        return strategy.selectElevator(controllers, floor, direction);
    }
}
