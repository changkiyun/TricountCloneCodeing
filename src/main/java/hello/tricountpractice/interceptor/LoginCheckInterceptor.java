package hello.tricountpractice.interceptor;

import hello.tricountpractice.MemberContext;
import hello.tricountpractice.TricountConst;
import hello.tricountpractice.model.entity.Member;
import hello.tricountpractice.model.response.MemberResponse;
import hello.tricountpractice.repository.MemberRepository;
import hello.tricountpractice.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LoginCheckInterceptor implements HandlerInterceptor {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        MemberResponse findMember = (MemberResponse) session.getAttribute(TricountConst.LOGIN_MEMBER);
        Member member = memberRepository.findByLoginIdAndLoginPassword(findMember.getLonginId(), findMember.getLoginPassword())
                .orElseThrow(() -> new RuntimeException("세션정보를 찾을 수 없습니다."));


        if (session == null) {
            throw new RuntimeException("세선이 존재하지 않습니다.");
        }

        try {
            MemberContext.setMember(member);
        } catch (Exception e) {
            throw new RuntimeException("ThreadLocal 저장에 실패했습니다.");
        }

        return true;

    }
}
