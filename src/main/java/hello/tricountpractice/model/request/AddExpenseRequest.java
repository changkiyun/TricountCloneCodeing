package hello.tricountpractice.model.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddExpenseRequest {
    private Long memberId;
    private String expenseName;
    private BigDecimal memberExpense;
}
