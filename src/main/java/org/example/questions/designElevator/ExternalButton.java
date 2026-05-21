package org.example.questions.designElevator;

import org.example.questions.designElevator.enums.Direction;

public class ExternalButton {
    private final ExternalDispatcher dispatcher;

    public ExternalButton(ExternalDispatcher dispatcher) {this.dispatcher = dispatcher;}

    public void pressButton(int floor, Direction direction){
        dispatcher.submitExternalRequest(floor, direction);
    }

}