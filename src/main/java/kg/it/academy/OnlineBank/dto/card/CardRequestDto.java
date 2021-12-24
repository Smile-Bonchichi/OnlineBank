package kg.it.academy.OnlineBank.dto.card;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardRequestDto {
    Long cardNumber;

    String currency;

    Long clientId;
}
