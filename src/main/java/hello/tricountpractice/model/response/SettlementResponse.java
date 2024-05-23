package hello.tricountpractice.model.response;

import hello.tricountpractice.model.entity.Member;
import hello.tricountpractice.model.entity.Settlement;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SettlementResponse {
    private Long settlementId;
    private String settlementName;
    private List<Member> joinMember;

    public static SettlementResponse changeResponse(Settlement settlement) {
        return new SettlementResponse(
                settlement.getSettleId(),
                settlement.getSettleName(),
                settlement.getMembers()
        );
    }
}
