package hello.tricountpractice.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Expense {
    @Id
    private Long expenseId;
    private String expenseName;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    private BigDecimal expenseAmount;
    private LocalDateTime expenseDate;
}
