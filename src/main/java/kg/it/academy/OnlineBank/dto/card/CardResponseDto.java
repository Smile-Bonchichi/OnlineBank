package kg.it.academy.OnlineBank.dto.card;

import kg.it.academy.OnlineBank.entity.Client;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardResponseDto {
    Long cardNumber;

    BigDecimal amount;

    String currency;

    Client client;
}
