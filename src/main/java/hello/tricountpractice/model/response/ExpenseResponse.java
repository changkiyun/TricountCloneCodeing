package hello.tricountpractice.model.response;

import hello.tricountpractice.model.entity.Expense;
import hello.tricountpractice.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ExpenseResponse {
    private Long expenseId;
    private String expenseName;
    private Member expenseMembers;
    private BigDecimal expenseAmount;
    private LocalDateTime expenseDate;

    public static ExpenseResponse changeResponse(Expense expense) {
        return new ExpenseResponse(
                expense.getExpenseId(),
                expense.getExpenseName(),
                expense.getMember(),
                expense.getExpenseAmount(),
                expense.getExpenseDate()
        );
    }
}
