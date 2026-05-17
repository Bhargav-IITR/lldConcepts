package org.example.observerPattern;

public class GoalNotifier implements FitnessDataObserver {
    private static final int STEP_GOAL = 10000;
    private boolean goalReached = false;

    @Override
    public void update(FitnessData data) {
        if (data.getSteps() >= STEP_GOAL && !goalReached) {
            System.out.println("Notifier -> Goal reached. You've hit " + STEP_GOAL + " steps.");
            goalReached = true;
        }
    }

    public void reset() {
        goalReached = false;
    }
}
