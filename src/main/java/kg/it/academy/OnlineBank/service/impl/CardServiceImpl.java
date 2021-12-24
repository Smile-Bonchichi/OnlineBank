package kg.it.academy.OnlineBank.service.impl;

import kg.it.academy.OnlineBank.dto.card.*;
import kg.it.academy.OnlineBank.entity.Card;
import kg.it.academy.OnlineBank.mappers.CardMapper;
import kg.it.academy.OnlineBank.repository.CardRepository;
import kg.it.academy.OnlineBank.repository.ClientRepository;
import kg.it.academy.OnlineBank.service.CardService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardServiceImpl implements CardService {
    final CardRepository cardRepository;
    final ClientRepository clientRepository;

    @Override
    public CardResponseDto save(CardRequestDto cardRequestDto) {
        Card card = CardMapper.INSTANCE.toCardEntity(cardRequestDto);
        card.setClient(clientRepository.findById(cardRequestDto.getClientId()).get());

        return CardMapper.INSTANCE.toCardResponseDto(cardRepository.save(card));
    }

    @Override
    public CardResponseDto checkCardAmount(Long cardNumber) {
        return CardMapper.INSTANCE.toCardResponseDto(cardRepository.getCardByCardNumber(cardNumber));
    }

    @Override
    @Transactional
    public CardReplenishmentResponseDto replenishmentAmountOnCard(CardReplenishmentRequestDto cardReplenishmentRequestDto) {
        Card card = cardRepository.getCardByCardNumber(cardReplenishmentRequestDto
                .getCardNumber());
        String amountOnCard = card.getAmount() == null ? "0" : card.getAmount().toString();

        cardRepository.updateAmountOnCard(
                (new BigDecimal(amountOnCard).add(cardReplenishmentRequestDto.getAmount())),
                cardReplenishmentRequestDto.getCardNumber()
        );

        return CardReplenishmentResponseDto.builder()
                .amount(amountOnCard + " + " +
                        cardReplenishmentRequestDto.getAmount().toString() + " -> " +
                        new BigDecimal(amountOnCard).add(cardReplenishmentRequestDto.getAmount()))
                .fullNameClient(card.getClient().getFullName())
                .build();
    }

    @Override
    @Transactional
    public CardWithdrawalAmount withdrawalCash(CardWithdrawalAmount cardWithdrawalAmount) {
        cardRepository.updateAmountOnCard(
                cardRepository.getCardByCardNumber(cardWithdrawalAmount.getCardNumber()).getAmount()
                        .subtract(
                                cardWithdrawalAmount.getAmount()
                        ), cardWithdrawalAmount.getCardNumber()
        );

        return CardWithdrawalAmount.builder()
                .cardNumber(cardWithdrawalAmount.getCardNumber())
                .amount(cardWithdrawalAmount.getAmount())
                .build();
    }
}
