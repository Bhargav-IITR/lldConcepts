package org.example.questions.designElevator;

import org.example.questions.designElevator.enums.Direction;

import java.util.List;

public interface ElevatorSelectionStrategy {
    ElevatorController selectElevator(List<ElevatorController> controllers, int requestFloor, Direction direction);
}
