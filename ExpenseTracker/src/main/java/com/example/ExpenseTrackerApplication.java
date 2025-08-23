package com.example;

import java.util.*;
import com.expensetracker.model.Expense;

public class ExpenseTrackerApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Edit Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addExpense();
                    break;
                case "2":
                    viewExpenses();
                    break;
                case "3":
                    editExpense();
                    break;
                case "4":
                    deleteExpense();
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addExpense() {
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter amount: ");
        Double amount = Double.parseDouble(scanner.nextLine());
        Expense expense = new Expense(UUID.randomUUID().toString(), description, amount);
        expenses.add(expense);
        System.out.println("Expense added.");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }
        System.out.println("Expenses:");
        for (int i = 0; i < expenses.size(); i++) {
            Expense e = expenses.get(i);
            System.out.printf("%d. [%s] %s - %.2f\n", i + 1, e.getId(), e.getDescription(), e.getAmount());
        }
    }

    private static void editExpense() {
        viewExpenses();
        if (expenses.isEmpty()) return;
        System.out.print("Enter expense number to edit: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= expenses.size()) {
            System.out.println("Invalid number.");
            return;
        }
        Expense e = expenses.get(idx);
        System.out.print("New description (" + e.getDescription() + "): ");
        String desc = scanner.nextLine();
        System.out.print("New amount (" + e.getAmount() + "): ");
        String amtStr = scanner.nextLine();
        if (!desc.isBlank()) e.setDescription(desc);
        if (!amtStr.isBlank()) e.setAmount(Double.parseDouble(amtStr));
        System.out.println("Expense updated.");
    }

    private static void deleteExpense() {
        viewExpenses();
        if (expenses.isEmpty()) return;
        System.out.print("Enter expense number to delete: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= expenses.size()) {
            System.out.println("Invalid number.");
            return;
        }
        expenses.remove(idx);
        System.out.println("Expense deleted.");
    }
}
