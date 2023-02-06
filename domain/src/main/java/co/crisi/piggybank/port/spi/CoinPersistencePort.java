package co.crisi.piggybank.port.spi;

import co.crisi.piggybank.data.CoinDto;
import java.util.List;

public interface CoinPersistencePort extends BasePersistencePort<CoinDto, Long> {

    List<CoinDto> findAllByPiggyBankId(Long piggyBankId);

}
