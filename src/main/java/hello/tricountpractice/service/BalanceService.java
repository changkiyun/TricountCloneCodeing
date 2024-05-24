package hello.tricountpractice.service;

import hello.tricountpractice.repository.BalanceRepository;
import hello.tricountpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final BalanceRepository balanceRepository;
    private final MemberRepository memberRepository;

    public void balance() {
        
    }
}
