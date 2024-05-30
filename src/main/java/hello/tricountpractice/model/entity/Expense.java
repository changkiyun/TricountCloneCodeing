package hello.tricountpractice.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;
    private String expenseName;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @JsonBackReference // 순환 참조 방지
    private Member member;
    private BigDecimal expenseAmount;
    private LocalDateTime expenseDate;

    public void changeMember(Member member) {
        this.member = member;
        member.setExpense(this);
    }


}
