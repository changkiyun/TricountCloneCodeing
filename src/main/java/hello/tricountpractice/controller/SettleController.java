package hello.tricountpractice.controller;

import hello.tricountpractice.model.response.SettlementResponse;
import hello.tricountpractice.repository.SettlementRepository;
import hello.tricountpractice.service.SettlementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SettleController {

    private final SettlementService settlementService;

    @PostMapping("/settles/create")
    public SettlementResponse createSettlement(@RequestParam String settlementName) {
        return settlementService.create(settlementName);
    }

    @PostMapping("/settles/{id}/join")
    public SettlementResponse joinSettlement(@PathVariable("id") Long settlementId) {
        return settlementService.join(settlementId);
    }
}
