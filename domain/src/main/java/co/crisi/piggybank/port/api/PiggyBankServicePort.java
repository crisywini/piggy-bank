package co.crisi.piggybank.port.api;

import co.crisi.piggybank.data.CoinDto;
import co.crisi.piggybank.data.PiggyBankDto;
import java.util.List;

public interface PiggyBankServicePort {


    PiggyBankDto findById(Long id);

    PiggyBankDto save(PiggyBankDto piggyBankDto);

    void close(Long id);

    Long getTotal(Long id);

    void deleteById(Long id);

    Long findCoinAmountByValueAnPiggyBankId(Long value, Long id);

}
