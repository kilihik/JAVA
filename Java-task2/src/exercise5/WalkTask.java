package exercise5;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class WalkTask implements Callable<WalkResult> {
    private final Animal pet;
    private final long programStartTime;
    private final double startOffsetSeconds;

    public WalkTask(Animal pet, long programStartTime, double startOffsetSeconds) {
        this.pet = pet;
        this.programStartTime = programStartTime;
        this.startOffsetSeconds = startOffsetSeconds;
    }

    @Override
    public WalkResult call() throws InterruptedException {
        if (startOffsetSeconds > 0) {
            TimeUnit.MILLISECONDS.sleep((long) (startOffsetSeconds * 1000));
        }

        double walkDuration = pet.goToWalk();
        double walkEndTime = startOffsetSeconds + walkDuration;

        return new WalkResult(pet.toString(), startOffsetSeconds, walkEndTime);
    }
}