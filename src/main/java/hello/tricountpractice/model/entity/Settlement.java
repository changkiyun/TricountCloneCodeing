package hello.tricountpractice.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @ManyToMany
    @JoinTable(
            name = "member_settlement", // 조인 테이블 이름
            joinColumns = @JoinColumn(name = "settle_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    @JsonManagedReference // 순환 참조 방지
    private List<Member> members = new ArrayList<>();
    private String settleName;

    public void setMembers(Member member) {
        members.add(member);
    }
}
