package org.example.questions.designElevator;

import org.example.questions.designElevator.enums.Direction;

public class Floor {
    int floorNumber;
    ExternalButton upBtn;
    ExternalButton dnBtn;
    public Floor(int floorNumber , ExternalDispatcher dispatcher){
        upBtn = new ExternalButton(dispatcher);
        dnBtn = new ExternalButton(dispatcher);
        this.floorNumber = floorNumber;
    }
    public void pressUpBtn(){
        upBtn.pressButton(floorNumber , Direction.UP);
    }

    public void pressDnBtn(){
        dnBtn.pressButton(floorNumber, Direction.DOWN);
    }
}
