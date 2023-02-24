package co.crisi.piggybank.service;

import co.crisi.piggybank.port.spi.PiggyBankPersistencePort;
import co.crisi.piggybank.service.model.PiggyBankMother;
import java.util.Optional;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class PiggyBankServicePortImplTest {

    @Mock
    private PiggyBankPersistencePort piggyBankPersistencePort;

    private PiggyBankServicePortImpl piggyBankServicePort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        piggyBankServicePort = new PiggyBankServicePortImpl(piggyBankPersistencePort);
    }

    @Test
    void getAmountByValueAndPiggyBank_whenNormalRequest_shouldGetTotalByValue() {

        val piggyBank = PiggyBankMother.getRandomPiggyBank();
        val coins = piggyBank.coins();

        Long value = coins.get(0).value();

        given(piggyBankPersistencePort.findById(piggyBank.id()))
                .willReturn(Optional.of(piggyBank));

        Long amountByValueAndPiggyBank = piggyBankServicePort
                .findCoinAmountByValueAnPiggyBankId(value, piggyBank.id());

        verify(piggyBankPersistencePort).findById(piggyBank.id());

        assertThat(amountByValueAndPiggyBank)
                .isNotNull()
                .isNotZero()
                .isNotNegative();
    }

    @Test
    void getAmountByValueAndPiggyBank_whenNoPiggyBankFoundIt_whatWouldHappen() {
        Long piggyBankId = 2L;
        given(piggyBankPersistencePort.findById(piggyBankId))
                .willReturn(Optional.of(PiggyBankMother.getRandomPiggyBankWithEmptyCoins()));


        Long amountByValueAndPiggyBank = piggyBankServicePort
                .findCoinAmountByValueAnPiggyBankId(3L, piggyBankId);

        verify(piggyBankPersistencePort).findById(piggyBankId);

        assertThat(amountByValueAndPiggyBank)
                .isNotNull()
                .isZero();
    }


}