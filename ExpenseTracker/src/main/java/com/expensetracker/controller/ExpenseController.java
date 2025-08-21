package com.expensetracker.controller;

import com.expensetracker.model.Expense;
import com.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Redirect root to /expenses
    @GetMapping("/")
    public String home() {
        return "redirect:/expenses";
    }

    @GetMapping
    public String listExpenses(Model model) {
        model.addAttribute("expenses", expenseRepository.findAll());
        return "expenses";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "create_expense";
    }

    @PostMapping("/create")
    public String createExpense(@ModelAttribute Expense expense) {
        expenseRepository.save(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Expense expense = expenseRepository.findById(id).orElse(null);
        model.addAttribute("expense", expense);
        return "edit_expense";
    }

    @PostMapping("/edit/{id}")
    public String updateExpense(@PathVariable String id, @ModelAttribute Expense expense) {
        expense.setId(id);
        expenseRepository.save(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable String id) {
        expenseRepository.deleteById(id);
        return "redirect:/expenses";
    }
}
