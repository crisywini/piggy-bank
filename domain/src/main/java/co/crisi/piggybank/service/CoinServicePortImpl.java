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
    public Long amountByValue(Long value) {
        return coinPersistencePort.findAll()
                .stream()
                .map(CoinDto::value)
                .filter(val -> val.equals(value))
                .reduce(Long::sum)
                .orElse(0L);
    }

}
