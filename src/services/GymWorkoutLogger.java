package services;

public class GymWorkoutLogger {
    public double calculateCaloriesBurned(int reps, double weight, double calorieFactor) {
        double weightFactor = weight / 100.0;
        return reps * calorieFactor * (1 + weightFactor);
    }
}
