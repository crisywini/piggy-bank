package co.crisi.piggybank.mapper;

import co.crisi.piggybank.data.CoinDto;
import co.crisi.piggybank.entity.Coin;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface CoinMapper {

    CoinDto mapToDto(Coin coin);

    Coin mapToEntity(CoinDto coinDto);

    List<CoinDto> mapToDtos(List<Coin> coins);

    List<Coin> mapToEntities(List<CoinDto> coinDtos);

}
