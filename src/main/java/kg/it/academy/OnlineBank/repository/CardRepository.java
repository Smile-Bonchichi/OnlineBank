package kg.it.academy.OnlineBank.repository;

import kg.it.academy.OnlineBank.entity.Card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query(nativeQuery = true, value = "SELECT t.* FROM cards t WHERE t.card_number = :cardNumber")
    Card getCardByCardNumber(Long cardNumber);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE cards SET amount = :amount WHERE card_number = :cardNumber")
    void updateAmountOnCard(BigDecimal amount, Long cardNumber);
}
