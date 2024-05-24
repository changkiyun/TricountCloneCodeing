package hello.tricountpractice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long balanceId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "member_id")
    private Member sendMember;
    private BigDecimal sendAmount;

    @OneToOne
    @MapsId
    @JoinColumn(name = "member_id")
    private Member receiverMember;

}
