package kg.it.academy.OnlineBank.controller;

import kg.it.academy.OnlineBank.dto.card.*;
import kg.it.academy.OnlineBank.service.CardService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/card")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardController {
    final CardService cardService;

    @PostMapping("/save")
    public CardResponseDto save(@RequestBody CardRequestDto cardRequestDto) {
        return cardService.save(cardRequestDto);
    }

    @GetMapping("/check-amount/{cardNumber}")
    public CardResponseDto getCardAmount(@PathVariable Long cardNumber) {
        return cardService.checkCardAmount(cardNumber);
    }

    @PostMapping("/update-amount")
    public CardReplenishmentResponseDto updateAmountOnCard(@RequestBody CardReplenishmentRequestDto cardReplenishmentRequestDto) {
        return cardService.replenishmentAmountOnCard(cardReplenishmentRequestDto);
    }

    @PostMapping("/cash-withdrawal")
    public CardWithdrawalAmount withdrawalCash(@RequestBody CardWithdrawalAmount cardWithdrawalAmount) {
        return cardService.withdrawalCash(cardWithdrawalAmount);
    }
}
