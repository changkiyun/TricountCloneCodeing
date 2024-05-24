package hello.tricountpractice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(unique = true)
    private String loginId;

    @Column(unique = true)
    private String loginPassword;

    private String name;

    @OneToOne(mappedBy = "sendMember", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Balance balance;

    @ManyToMany(mappedBy = "members")
    @JsonIgnore // 순환 참조 방지
    private List<Settlement> settle;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // 순환 참조 방지
    private List<Expense> expenses = new ArrayList<>();

    public void setSettle(Settlement settlement) {
        settle.add(settlement);
    }

    public void setExpense(Expense expense) {
        expenses.add(expense);
    }


}
