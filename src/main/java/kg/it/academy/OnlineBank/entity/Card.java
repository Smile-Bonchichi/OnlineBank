package kg.it.academy.OnlineBank.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Card extends BaseEntity {
    @Column(name = "card_number", nullable = false, unique = true)
    Long cardNumber;

    @Column(name = "amount")
    BigDecimal amount;

    @Column(name = "currency", nullable = false)
    String currency;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    Client client;
}
