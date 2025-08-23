# Expense Tracker Application

A simple console-based expense tracking application built with Java and Maven.

## Features

- Add new expenses with description and amount
- View all expenses
- Edit existing expenses
- Delete expenses
- Simple console-based interface

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## How to Run

### Option 1: Using Maven (Recommended)

1. Navigate to the project directory:
   ```bash
   cd ExpenseTracker
   ```

2. Run the application:
   ```bash
   mvn exec:java
   ```

### Option 2: Using the JAR file

1. Build the JAR file:
   ```bash
   mvn package
   ```

2. Run the JAR file:
   ```bash
   java -jar target/ExpenseTracker-0.0.1-SNAPSHOT.jar
   ```

## Usage

The application provides a simple menu-driven interface:

1. **Add Expense** - Enter a description and amount for a new expense
2. **View Expenses** - Display all current expenses
3. **Edit Expense** - Modify an existing expense's description or amount
4. **Delete Expense** - Remove an expense from the list
5. **Exit** - Close the application

## Project Structure

```
ExpenseTracker/
├── src/main/java/
│   └── com/
│       ├── example/
│       │   └── ExpenseTrackerApplication.java  # Main application class
│       └── expensetracker/
│           └── model/
│               └── Expense.java                # Expense data model
├── pom.xml                                      # Maven configuration
└── README.md                                    # This file
```

## Notes

- This is a console application that stores data in memory (data is lost when the application is closed)
- Each expense has a unique ID, description, and amount
- The application uses Java 17 features

## Troubleshooting

If you encounter any issues:

1. Make sure Java 17+ is installed: `java -version`
2. Make sure Maven is installed: `mvn -version`
3. Try cleaning and rebuilding: `mvn clean compile`
4. Check that you're in the correct directory (ExpenseTracker folder)
