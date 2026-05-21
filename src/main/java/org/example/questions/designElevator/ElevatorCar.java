package org.example.questions.designElevator;

import org.example.questions.designElevator.enums.Direction;

import java.security.DigestException;

public class ElevatorCar {
    int id;
    int currentFloor;
    int nextFloorStop;
    Direction direction;
    Door door;
    public ElevatorCar(int id){
        this.id = id;
        door = new Door();
        currentFloor = 0;
        direction = Direction.IDLE;
    }
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    // move function
    public void moveElevator(int destinationFloor){
        this.nextFloorStop = destinationFloor;
        if(this.currentFloor == nextFloorStop){
            door.openDoor(id);
            return;
        }
        int startFloor = this.currentFloor;
        door.closeDoor(id);
        if(nextFloorStop >= currentFloor){
            direction = Direction.UP;
            showDisplay();
            for (int i = startFloor+1; i<= nextFloorStop; i++) {
                try {
                    Thread.sleep(5); // -> simulate elevator car movement
                }catch (Exception e) {

                }
                setCurrentFloor(i);
                showDisplay();
            }
        }else{
            direction = Direction.DOWN;
            showDisplay();
            for (int i = startFloor-1; i>= nextFloorStop; i--) {
                try {
                    Thread.sleep(5);
                }catch (Exception e) {

                }
                setCurrentFloor(i);
                showDisplay();
            }
        }
        door.openDoor(id);
    }

    public void showDisplay() {
        System.out.println("elevator:" + id + " Current floor: " + currentFloor + " going: " + direction);
    }
}
