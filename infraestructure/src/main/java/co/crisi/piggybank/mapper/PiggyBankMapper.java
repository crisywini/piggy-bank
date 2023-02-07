package co.crisi.piggybank.mapper;

import co.crisi.piggybank.data.PiggyBankDto;
import co.crisi.piggybank.entity.PiggyBank;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = CoinMapper.class)
public interface PiggyBankMapper {


    PiggyBankDto mapToDto(PiggyBank piggyBank);

    PiggyBank mapToEntity(PiggyBankDto piggyBankDto);

    @AfterMapping
    default void solveCoinsReferences(
            @MappingTarget
                    PiggyBank piggyBank) {

        piggyBank.getCoins().forEach(coin -> coin.setPiggyBank(piggyBank));
    }


}
