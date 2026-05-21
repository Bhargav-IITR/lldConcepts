package org.example.questions.designElevator;

import org.example.questions.designElevator.enums.Direction;

import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorController implements Runnable{
    // LOOK ALGORITHM

    PriorityBlockingQueue<Integer> upMinPQ; // for dir up
    PriorityBlockingQueue<Integer> downMaxPQ; // for dir down
    ElevatorCar elevatorCar;

    private final Object monitor = new Object();

    ElevatorController (ElevatorCar elevatorCar){
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityBlockingQueue<>();
        downMaxPQ = new PriorityBlockingQueue<>();
    }

    public void submitRequest(int destinationFloor){
        enqueueRequest(destinationFloor);
    }

    private void enqueueRequest(int destinationFloor){
        System.out.println("Request details-> destinationFloor: " + destinationFloor + " accepted by elevator:" + elevatorCar.id);
        if(destinationFloor == elevatorCar.nextFloorStop) return;
        if(destinationFloor >= elevatorCar.nextFloorStop){
            if(!upMinPQ.contains(destinationFloor)){
                upMinPQ.offer(destinationFloor);
            }else{
                if(!downMaxPQ.contains((destinationFloor))){
                    downMaxPQ.offer(destinationFloor);
                }
            }
        }

        synchronized (monitor){
            monitor.notify();
        }
    }

    @Override
    public void run(){
        controlElevator();
    }

    public void controlElevator(){
        while(true){
            // if no request go to sleep
            synchronized (monitor){
                while(upMinPQ.isEmpty() && downMaxPQ.isEmpty()){
                    try {
                        System.out.println("elevator:" + elevatorCar.id + " is IDLE");
                        elevatorCar.direction = Direction.IDLE;
                        monitor.wait(); // sleep until request arrives
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            while (!upMinPQ.isEmpty()) {
                int floor = upMinPQ.poll();
                System.out.println("Serving floor: " + floor + " by elevator:" + elevatorCar.id + " currentFloor: " + elevatorCar.currentFloor);
                elevatorCar.moveElevator(floor);
            }


            while (!downMaxPQ.isEmpty()) {
                int floor = downMaxPQ.poll();
                System.out.println("Serving floor: " + floor + " by elevator:" + elevatorCar.id + " currentFloor: " + elevatorCar.currentFloor);
                elevatorCar.moveElevator(floor);
            }
        }
    }
}
