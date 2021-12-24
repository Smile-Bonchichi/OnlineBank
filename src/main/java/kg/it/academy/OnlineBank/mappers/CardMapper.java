package kg.it.academy.OnlineBank.mappers;

import kg.it.academy.OnlineBank.dto.card.CardRequestDto;
import kg.it.academy.OnlineBank.dto.card.CardResponseDto;
import kg.it.academy.OnlineBank.entity.Card;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    Card toCardEntity(CardRequestDto cardRequestDto);

    CardResponseDto toCardResponseDto(Card card);
}
