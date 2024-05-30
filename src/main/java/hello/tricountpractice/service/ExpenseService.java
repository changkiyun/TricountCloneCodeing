package hello.tricountpractice.service;

import hello.tricountpractice.MemberContext;
import hello.tricountpractice.model.entity.Expense;
import hello.tricountpractice.model.request.AddExpenseRequest;
import hello.tricountpractice.model.response.ExpenseResponse;
import hello.tricountpractice.repository.ExpenseRepository;
import hello.tricountpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final MemberRepository memberRepository;

    public ExpenseResponse addExpense(AddExpenseRequest request) {
        Expense expense = new Expense();
        expense.setExpenseName(request.getExpenseName());
        expense.setExpenseAmount(request.getMemberExpense());
        expense.setExpenseDate(LocalDateTime.now());

        expense.changeMember(MemberContext.getMember());

        return ExpenseResponse.changeResponse(expenseRepository.save(expense));
    }
}
