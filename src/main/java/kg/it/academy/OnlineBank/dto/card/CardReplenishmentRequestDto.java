package kg.it.academy.OnlineBank.dto.card;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardReplenishmentRequestDto {
    Long cardNumber;

    BigDecimal amount;
}
