package hello.tricountpractice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Settlement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long settleId;
    @ManyToMany(mappedBy = "settle")
    private List<Member> joinMember = new ArrayList<>();
    private String settleName;

    public void setJoinMember(Member member) {
        joinMember.add(member);
    }
}
