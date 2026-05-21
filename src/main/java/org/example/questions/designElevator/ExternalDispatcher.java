package org.example.questions.designElevator;

import org.example.questions.designElevator.enums.Direction;

public class ExternalDispatcher {
    ElevatorScheduler scheduler;
    public ExternalDispatcher(ElevatorScheduler scheduler){ this.scheduler = scheduler;}

    public void submitExternalRequest(int floor, Direction direction){
        ElevatorController controller = scheduler.assignElevator(floor, direction);
        controller.submitRequest(floor);
    }
}
