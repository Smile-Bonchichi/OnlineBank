package kg.it.academy.OnlineBank.service;

import kg.it.academy.OnlineBank.dto.card.*;

public interface CardService {
    CardResponseDto save(CardRequestDto cardRequestDto);

    CardResponseDto checkCardAmount(Long cardNumber);

    CardReplenishmentResponseDto replenishmentAmountOnCard(CardReplenishmentRequestDto cardReplenishmentRequestDto);

    CardWithdrawalAmount withdrawalCash(CardWithdrawalAmount cardWithdrawalAmount);
}
