package hello.tricountpractice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    @ManyToMany
    @JoinTable(
            name = "member_settlement",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "settlement_id")
    )
    private List<Settlement> settle;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Expense> expenses = new ArrayList<>();

    public void setSettle(Settlement settlement) {
        settle.add(settlement);
    }
}
