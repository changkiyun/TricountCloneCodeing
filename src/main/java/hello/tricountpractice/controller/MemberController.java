package hello.tricountpractice.controller;

import hello.tricountpractice.TricountConst;
import hello.tricountpractice.model.request.LoginRequest;
import hello.tricountpractice.model.request.SignupRequest;
import hello.tricountpractice.model.response.MemberResponse;
import hello.tricountpractice.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public MemberResponse signup(@RequestBody SignupRequest signupRequest) {
        return memberService.signup(signupRequest.getLoginId(), signupRequest.getLoginPassword(), signupRequest.getName());
    }

    @PostMapping("/login")
    public MemberResponse login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        MemberResponse findId = memberService.login(loginRequest.getLoginId(), loginRequest.getLoginPassword());
        session.setAttribute(TricountConst.LOGIN_MEMBER, findId);
        return findId;
    }

    @GetMapping("/profile")
    public ResponseEntity<MemberResponse> getProfile(@SessionAttribute(TricountConst.LOGIN_MEMBER) MemberResponse member) {
        return ResponseEntity.ok(member);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return new ResponseEntity<>("로그아웃 되었습니다.", HttpStatus.OK);
    }
}
