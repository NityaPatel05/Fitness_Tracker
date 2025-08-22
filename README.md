

# Fitness Tracker Application

A Java-based fitness tracking application built to demonstrate core Object-Oriented Programming (OOP) concepts. This project allows users to set fitness goals, log workouts, and track calorie intake, while showcasing clean code design and OOP principles.

## Object-Oriented Programming Concepts

### 1. Inheritance

* `FitnessTracker` class extends abstract `Person` class
* Demonstrates the "is-a" relationship and code reuse

### 2. Interface Implementation

* `FitnessTracker` implements `WorkoutLogger` interface
* Enforces contract-driven design for workout logging

### 3. Abstraction

* Abstract `Person` class with abstract method `displaySummary()`
* `WorkoutLogger` interface defines essential behavior
* Hides implementation details and exposes essential functionality

### 4. Encapsulation

* Private fields with controlled access through public methods
* Ensures data integrity and maintainability

### 5. Polymorphism

* Method overriding using `@Override`
* Interface implementation enabling multiple behaviors
* Promotes flexibility and dynamic method resolution

### 6. Constructor Usage

* Parameterized constructor with `super()` for proper initialization
* Demonstrates inheritance chain setup

## Project Structure

```
fitness-tracker/
├── main/
│   └── FitnessTrackerApp.java    # Main application class
├── model/
│   └── Person.java               # Abstract base class
└── services/
    ├── WorkoutLogger.java        # Interface for workout logging
    └── GymWorkoutLogger.java     # Utility class for gym workouts
```

## Features

* **Goal Setting**: Support for weight gain, loss, and maintenance
* **Calorie Tracking**: Calculates daily calorie targets and macronutrient breakdown
* **Workout Logging**: Supports cycling, running, push-ups, and gym-based exercises
* **Data Persistence**: Saves workout and nutrition data to files
* **Error Handling**: Input validation and exception management

## How to Run

1. Compile the project:

   ```bash
   javac -d . main/FitnessTrackerApp.java
   ```

2. Run the application:

   ```bash
   java main.FitnessTrackerApp
   ```

3. Follow the prompts to set goals, log workouts, and track progress.

## Learning Outcomes

* Demonstrated mastery of OOP concepts: inheritance, abstraction, encapsulation, polymorphism, and interfaces
* Applied software engineering principles: modular design, separation of concerns,
