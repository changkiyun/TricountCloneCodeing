package hello.tricountpractice.service;

import hello.tricountpractice.MemberContext;
import hello.tricountpractice.model.entity.Settlement;
import hello.tricountpractice.model.response.SettlementResponse;
import hello.tricountpractice.repository.SettlementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettlementService {

    private final SettlementRepository settlementRepository;

    public SettlementResponse create(String settlementName) {
        Settlement settlement = new Settlement();
        settlement.setSettleName(settlementName);
        MemberContext.getMember().setSettle(settlement);
        settlement.setMembers(MemberContext.getMember());

        return SettlementResponse.changeResponse(settlementRepository.save(settlement));
    }

    public SettlementResponse join(Long settlementId) {
        Settlement settlement = settlementRepository.findById(settlementId)
                .orElseThrow(() -> new RuntimeException("조인할 정산방을 찾을 수 없습니다."));
        MemberContext.getMember().setSettle(settlement);
        settlement.setMembers(MemberContext.getMember());

        return SettlementResponse.changeResponse(settlement);
    }
}
