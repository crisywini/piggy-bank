package co.crisi.piggybank.service;

import co.crisi.piggybank.data.CoinDto;
import co.crisi.piggybank.port.api.CoinServicePort;
import co.crisi.piggybank.port.spi.CoinPersistencePort;

public class CoinServicePortImpl implements CoinServicePort {

    private CoinPersistencePort coinPersistencePort;

    @Override
    public CoinDto save(CoinDto coinDto) {
        return coinPersistencePort.save(coinDto);
    }

    @Override
    public Long amountByValueAndPiggyBank(Long value, Long piggyBankId) {
        return coinPersistencePort.findAll()
                .stream()
                .filter(coin -> coin.piggyBank().id().equals(piggyBankId))
                .map(CoinDto::value)
                .filter(val -> val.equals(value))
                .reduce(Long::sum)
                .orElse(0L);
    }

}
