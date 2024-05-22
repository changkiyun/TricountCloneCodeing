package hello.tricountpractice.service;

import hello.tricountpractice.model.entity.Member;
import hello.tricountpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public hello.tricountpractice.model.response.MemberResponse signup(String loginId, String loginPassword, String name) {
        Member member = new Member();
        member.setLoginId(loginId);
        member.setLoginPassword(loginPassword);
        member.setName(name);

        return hello.tricountpractice.model.response.MemberResponse.changeResponse(memberRepository.save(member));
    }

    public hello.tricountpractice.model.response.MemberResponse login(String loginId, String loginPassword) {
        return memberRepository.findByLoginIdAndLoginPassword(loginId, loginPassword)
                .map(hello.tricountpractice.model.response.MemberResponse::changeResponse)
                .orElseThrow(() -> new RuntimeException("등록되지 않은 사용자 입니다."));

    }
}
