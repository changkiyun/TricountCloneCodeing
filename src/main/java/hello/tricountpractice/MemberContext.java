package hello.tricountpractice;

import hello.tricountpractice.model.entity.Member;
import hello.tricountpractice.model.response.MemberResponse;

public class MemberContext {

    private static final ThreadLocal<Member> memberThreadLocal = new ThreadLocal<>();

    public static void setMember(Member member) {
        memberThreadLocal.set(member);
    }

    public static Member getMember() {
        return memberThreadLocal.get();
    }
}
