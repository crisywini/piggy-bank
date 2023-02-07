package co.crisi.piggybank.service;

import co.crisi.piggybank.data.CoinDto;
import co.crisi.piggybank.port.api.CoinServicePort;
import co.crisi.piggybank.port.spi.CoinPersistencePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CoinServicePortImpl implements CoinServicePort {

    private CoinPersistencePort coinPersistencePort;

    @Override
    public CoinDto save(CoinDto coinDto) {
        return coinPersistencePort.save(coinDto);
    }

    public void setCoinPersistencePort(CoinPersistencePort coinPersistencePort){
        this.coinPersistencePort = coinPersistencePort;
    }

}
