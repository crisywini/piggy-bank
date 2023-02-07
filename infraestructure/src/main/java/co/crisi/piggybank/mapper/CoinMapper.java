package co.crisi.piggybank.mapper;

import co.crisi.piggybank.data.CoinDto;
import co.crisi.piggybank.entity.Coin;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CoinMapper {

    @Mapping(target = "piggyBank", ignore = true)
    CoinDto mapToDto(Coin coin);

    @Mapping(target = "piggyBank", ignore = true)
    Coin mapToEntity(CoinDto coinDto);

    List<CoinDto> mapToDtos(List<Coin> coins);

    List<Coin> mapToEntities(List<CoinDto> coinDtos);

}
