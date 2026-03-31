package exercise5;

import java.util.Locale;

public class WalkResult {
    private final String petInfo;
    private final double startTime;
    private final double endTime;

    public WalkResult(String petInfo, double startTime, double endTime) {
        this.petInfo = petInfo;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public double getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s, start time = %.2f, end time = %.2f", 
                petInfo, startTime, endTime);
    }
}