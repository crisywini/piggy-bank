package co.crisi.piggybank.service;

import co.crisi.piggybank.data.CoinDto;
import co.crisi.piggybank.data.PiggyBankDto;
import co.crisi.piggybank.port.api.CoinServicePort;
import co.crisi.piggybank.port.spi.CoinPersistencePort;
import co.crisi.piggybank.service.model.CoinDtoMother;
import co.crisi.piggybank.service.model.PiggyBankMother;
import java.util.Collections;
import java.util.List;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;


class CoinServicePortImplTest {

    @Mock
    private CoinPersistencePort coinPersistencePort;

    private CoinServicePortImpl coinServicePortImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        coinServicePortImpl = new CoinServicePortImpl();
        coinServicePortImpl.setCoinPersistencePort(coinPersistencePort);
    }


    @Test
    void saveCoin_whenNormalRequest_shouldBeSuccessful() {
        val randomPiggyBank = PiggyBankMother.getRandomPiggyBankWithEmptyCoins();
        val coin = CoinDtoMother.getRandomCoin(randomPiggyBank);
        val savedCoin = CoinDtoMother.getSavedCoin(coin);

        given(coinPersistencePort.save(coin))
                .willReturn(savedCoin);

        val savedCoinDto = coinServicePortImpl.save(coin);

        verify(coinPersistencePort).save(coin);
        assertThat(savedCoinDto)
                .isNotNull()
                .isEqualTo(savedCoin);
    }

}