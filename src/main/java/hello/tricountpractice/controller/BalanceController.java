package hello.tricountpractice.controller;

import hello.tricountpractice.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;
}
