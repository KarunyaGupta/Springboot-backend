package com.example;

import java.util.*;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;
import com.expensetracker.service.AuthService;

public class ExpenseTrackerApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, List<Expense>> usernameToExpenses = new HashMap<>();
    private static User currentUser = null;

    public static void main(String[] args) {
        AuthService authService = new AuthService();
        while (true) {
            if (currentUser == null) {
                showAuthMenu(authService);
                continue;
            }

            System.out.println("\nExpense Tracker Menu (User: " + currentUser.getUsername() + "):");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Edit Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
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
                    currentUser = null;
                    System.out.println("Logged out.");
                    break;
                case "6":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showAuthMenu(AuthService authService) {
        System.out.println("\nAuthentication Menu:");
        System.out.println("1. Login");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Username: ");
                String loginUser = scanner.nextLine();
                System.out.print("Password: ");
                String loginPass = scanner.nextLine();
                User loggedIn = authService.login(loginUser, loginPass);
                if (loggedIn != null) {
                    currentUser = loggedIn;
                    usernameToExpenses.putIfAbsent(currentUser.getUsername(), new ArrayList<>());
                    System.out.println("Login successful.");
                } else {
                    System.out.println("Invalid credentials.");
                }
                break;
            case "2":
                System.out.print("Choose a username: ");
                String newUser = scanner.nextLine();
                System.out.print("Choose a password: ");
                String newPass = scanner.nextLine();
                boolean created = authService.signUp(newUser, newPass);
                if (created) {
                    System.out.println("Sign up successful. You can now log in.");
                } else {
                    System.out.println("Username already exists. Try another.");
                }
                break;
            case "3":
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private static void addExpense() {
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter amount: ");
        Double amount = Double.parseDouble(scanner.nextLine());
        Expense expense = new Expense(UUID.randomUUID().toString(), description, amount);
        List<Expense> expenses = getUserExpenses();
        expenses.add(expense);
        System.out.println("Expense added.");
    }

    private static void viewExpenses() {
        List<Expense> expenses = getUserExpenses();
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
        List<Expense> expenses = getUserExpenses();
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
        List<Expense> expenses = getUserExpenses();
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

    private static List<Expense> getUserExpenses() {
        usernameToExpenses.putIfAbsent(currentUser.getUsername(), new ArrayList<>());
        return usernameToExpenses.get(currentUser.getUsername());
    }
}
