package co.crisi.piggybank.config;

import co.crisi.piggybank.adapter.PiggyBankJpaAdapter;
import co.crisi.piggybank.port.api.PiggyBankServicePort;
import co.crisi.piggybank.port.spi.PiggyBankPersistencePort;
import co.crisi.piggybank.service.PiggyBankServicePortImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PiggyBankConfig {
    
    @Bean
    public PiggyBankPersistencePort piggyBankPersistence() {
        return new PiggyBankJpaAdapter();
    }

    @Bean
    public PiggyBankServicePort piggyBankService() {
        return new PiggyBankServicePortImpl(piggyBankPersistence());
    }

}
