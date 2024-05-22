package hello.tricountpractice.model.response;

import hello.tricountpractice.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MemberResponse {
    private Long id;
    private String longinId;
    private String loginPassword;
    private String name;

    public static MemberResponse changeResponse(Member member) {
        return new MemberResponse(
                member.getMemberId(),
                member.getLoginId(),
                member.getLoginPassword(),
                member.getName()
        );
    }
}
