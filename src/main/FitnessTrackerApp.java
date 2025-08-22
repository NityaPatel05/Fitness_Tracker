    // File: main/FitnessTrackerApp.java
package main;

import models.Person;
import services.WorkoutLogger;
import services.GymWorkoutLogger;

import java.io.*;
import java.util.Scanner;

// FitnessTracker class extends Person and implements WorkoutLogger
public class FitnessTracker extends Person implements WorkoutLogger {
    private double maintenanceCalories;
    private String goal;
    private double targetCalories;
    private double remainingCalories;
    private double totalCaloriesBurned;
    private double fatRatio = 0.25;
    private double carbRatio = 0.50;
    private double proteinRatio = 0.25;

    // Constructor
    public FitnessTracker(String name, double maintenanceCalories, String goal) {
        super(name); // Using super keyword
        this.maintenanceCalories = maintenanceCalories;
        this.goal = goal;
        setGoal(goal);
        this.totalCaloriesBurned = 0;
    }

    // Method to set the goal and adjust target calories
    public void setGoal(String goal) {
        if (goal.equalsIgnoreCase("gain")) {
            targetCalories = maintenanceCalories + 200; // 200-calorie surplus
        } else if (goal.equalsIgnoreCase("lose")) {
            targetCalories = maintenanceCalories - 200; // 200-calorie deficit
        } else if (goal.equalsIgnoreCase("maintain")) {
            targetCalories = maintenanceCalories;
        } else {
            System.out.println("Invalid goal! Setting to maintain calories.");
            targetCalories = maintenanceCalories;
        }
        remainingCalories = targetCalories;
        displayMacroTargets();
    }

    // Method to display macronutrient breakdown
    private void displayMacroTargets() {
        System.out.println("\n--- Daily Macronutrient Breakdown ---");
        System.out.printf("Calories from Fat: %.2f (%.2f grams)%n", targetCalories * fatRatio, (targetCalories * fatRatio) / 9);
        System.out.printf("Calories from Carbs: %.2f (%.2f grams)%n", targetCalories * carbRatio, (targetCalories * carbRatio) / 4);
        System.out.printf("Calories from Protein: %.2f (%.2f grams)%n", targetCalories * proteinRatio, (targetCalories * proteinRatio) / 4);
    }

    // Method to log workout details
    @Override
    public void logWorkout() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nEnter workout details (enter 0 if not done):");

            System.out.print("Cycling (minutes): ");
            int cyclingMinutes = scanner.nextInt();
            totalCaloriesBurned += cyclingMinutes * 8;

            System.out.print("Running (minutes): ");
            int runningMinutes = scanner.nextInt();
            totalCaloriesBurned += runningMinutes * 10;

            System.out.print("Push-ups (reps): ");
            int pushUpsReps = scanner.nextInt();
            totalCaloriesBurned += pushUpsReps * 0.3;

            System.out.println("Total calories burned from workout: " + totalCaloriesBurned);
        } catch (Exception e) {
            System.out.println("Error in logging workout: " + e.getMessage());
        }
    }

    // Additional methods remain the same...
    // ... Including logGymWorkout, calculateCaloriesBurned, updateCalorieIntake, displaySummary, saveToFile

    // Main method
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Fitness Tracker!");

            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Please enter your maintenance calories (find this at calculator.net): ");
            double maintenanceCalories = scanner.nextDouble();

            System.out.println("\nChoose your goal:\n1. Gain Weight\n2. Lose Weight\n3. Maintain Weight");
            System.out.print("Enter your choice (gain/lose/maintain): ");
            String goal = scanner.next();

            // Create FitnessTracker instance
            FitnessTracker user = new FitnessTracker(name, maintenanceCalories, goal);

            // Log workout details
            user.logWorkout();
            System.out.print("Do you do gym workouts? (yes/no): ");
            String gymChoice = scanner.next();
            if (gymChoice.equalsIgnoreCase("yes")) {
                user.logGymWorkout();
            }

            // Update calorie intake details
            while (true) {
                System.out.print("\nWould you like to update your intake? (yes/no): ");
                String choice = scanner.next();
                if (!choice.equalsIgnoreCase("yes")) break;

                // Intake handling code...
            }

            // Display summary and save data
            user.displaySummary();
            user.saveToFile();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
