package hello.tricountpractice.controller;

import hello.tricountpractice.model.request.AddExpenseRequest;
import hello.tricountpractice.model.response.ExpenseResponse;
import hello.tricountpractice.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping("/expenses/add")
    public ExpenseResponse addExpense(@RequestBody AddExpenseRequest addExpenseRequest) {
        return expenseService.addExpense(addExpenseRequest);
    }
}
