package com.example.pftui.controller;

import com.example.pftui.model.Transaction;
import com.example.pftui.security.CustomUserDetails;
import com.example.pftui.service.AccountService;
import com.example.pftui.service.CategoryService;
import com.example.pftui.service.ExportService;
import com.example.pftui.service.TransactionService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
@RequestMapping("/transactions")
public class TransactionController {
    
    private final TransactionService transactionService;
    private final AccountService accountService;
    private final CategoryService categoryService;
    private final ExportService exportService;
    
    public TransactionController(TransactionService transactionService,
                                AccountService accountService,
                                CategoryService categoryService,
                                ExportService exportService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
        this.categoryService = categoryService;
        this.exportService = exportService;
    }
    
    /**
     * Display transactions list page
     */
    @GetMapping
    public String list(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            String userId = userDetails.getUser().getId();
            
            model.addAttribute("currentUser", userDetails.getUser());
            model.addAttribute("transactions", transactionService.getAllTransactionsByUser(userId));
            model.addAttribute("categories", categoryService.getAllCategoriesForUser(userId));
            model.addAttribute("accounts", accountService.getActiveAccountsByUser(userId));
        }
        
        model.addAttribute("active", "transactions");
        return "transactions";
    }
    
    /**
     * Create a new transaction
     */
    @PostMapping
    public String create(@RequestParam String accountId,
                        @RequestParam String categoryId,
                        @RequestParam BigDecimal amount,
                        @RequestParam String merchant,
                        @RequestParam(required = false) String note,
                        @RequestParam String date,
                        RedirectAttributes redirectAttributes) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            
            if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
                CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
                String userId = userDetails.getUser().getId();
                
                Transaction transaction = new Transaction();
                transaction.setUserId(userId);
                transaction.setAccountId(accountId);
                transaction.setCategoryId(categoryId);
                transaction.setAmount(amount);
                transaction.setMerchant(merchant);
                transaction.setNote(note);
                transaction.setDate(LocalDate.parse(date));
                transaction.setRecurring(false);
                
                transactionService.createTransaction(transaction);
                
                redirectAttributes.addFlashAttribute("successMessage", "Transaction added successfully!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error adding transaction: " + e.getMessage());
        }
        
        return "redirect:/transactions";
    }
    
    /**
     * Delete a transaction
     */
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            
            if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
                CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
                String userId = userDetails.getUser().getId();
                
                transactionService.deleteTransaction(id, userId);
                redirectAttributes.addFlashAttribute("successMessage", "Transaction deleted successfully!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting transaction: " + e.getMessage());
        }
        
        return "redirect:/transactions";
    }
    
    /**
     * Update a transaction
     */
    @PostMapping("/{id}/update")
    public String update(@PathVariable String id,
                        @RequestParam String accountId,
                        @RequestParam String categoryId,
                        @RequestParam BigDecimal amount,
                        @RequestParam String merchant,
                        @RequestParam(required = false) String note,
                        @RequestParam String date,
                        RedirectAttributes redirectAttributes) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            
            if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
                CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
                String userId = userDetails.getUser().getId();
                
                Transaction transaction = new Transaction();
                transaction.setUserId(userId);
                transaction.setAccountId(accountId);
                transaction.setCategoryId(categoryId);
                transaction.setAmount(amount);
                transaction.setMerchant(merchant);
                transaction.setNote(note);
                transaction.setDate(LocalDate.parse(date));
                
                transactionService.updateTransaction(id, transaction);
                redirectAttributes.addFlashAttribute("successMessage", "Transaction updated successfully!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error updating transaction: " + e.getMessage());
        }
        
        return "redirect:/transactions";
    }
    
    /**
     * Export transactions to CSV
     */
    @GetMapping("/export/csv")
    public void exportCsv(HttpServletResponse response) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            String userId = userDetails.getUser().getId();

            response.setContentType("text/csv; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=\"transactions.csv\"");
            
            exportService.exportTransactionsToCsv(userId, response.getWriter());
        }
    }
}

