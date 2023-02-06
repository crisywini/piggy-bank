package co.crisi.piggybank.service;

import co.crisi.piggybank.data.CoinDto;
import co.crisi.piggybank.data.PiggyBankDto;
import co.crisi.piggybank.exception.ResourceNotFoundException;
import co.crisi.piggybank.port.api.PiggyBankServicePort;
import co.crisi.piggybank.port.spi.PiggyBankPersistencePort;
import java.util.Collections;
import lombok.val;

public class PiggyBankServicePortImpl implements PiggyBankServicePort {


    private PiggyBankPersistencePort piggyBankPersistencePort;

    @Override
    public PiggyBankDto findById(Long id) {
        return piggyBankPersistencePort.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                String.format("The entity with id %d  was not found", id)));
    }

    @Override
    public PiggyBankDto save(PiggyBankDto piggyBankDto) {
        return piggyBankPersistencePort.save(piggyBankDto);
    }

    @Override
    public void close(Long id) {

        val piggyBank = findById(id);

        val piggyBankDtoUpdated = new PiggyBankDto(piggyBank.id(),
                Collections.emptyList());

        piggyBankPersistencePort.save(piggyBankDtoUpdated);
    }

    @Override
    public Long getTotal(Long id) {
        val piggyBankDto = findById(id);
        return piggyBankDto.coins().stream()
                .map(coin -> coin.amount() * coin.value())
                .reduce(Long::sum)
                .orElse(0L);
    }

    @Override
    public void deleteById(Long id) {
        piggyBankPersistencePort.deleteById(id);
    }

    @Override
    public Long findCoinAmountByValueAnPiggyBankId(Long value, Long id) {
        val piggyBank = findById(id);
        return piggyBank.coins().stream()
                .map(CoinDto::value)
                .filter(val -> val.equals(value))
                .reduce(Long::sum)
                .orElse(0L);
    }

    public void setPiggyBankPersistencePort(PiggyBankPersistencePort piggyBankPersistencePort) {
        this.piggyBankPersistencePort = piggyBankPersistencePort;
    }

}
