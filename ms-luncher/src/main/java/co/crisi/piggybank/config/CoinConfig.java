package co.crisi.piggybank.config;

import co.crisi.piggybank.adapter.CoinJpaAdapter;
import co.crisi.piggybank.port.api.CoinServicePort;
import co.crisi.piggybank.port.spi.CoinPersistencePort;
import co.crisi.piggybank.service.CoinServicePortImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoinConfig {

    @Bean
    public CoinPersistencePort coinPersistence(){
        return new CoinJpaAdapter();
    }

    @Bean
    public CoinServicePort coinService(){
        return new CoinServicePortImpl(coinPersistence());
    }

}
