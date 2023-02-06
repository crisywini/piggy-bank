package co.crisi.piggybank.port.api;

import co.crisi.piggybank.data.CoinDto;

public interface CoinServicePort {

    CoinDto save(CoinDto coinDto);

    Long amountByValueAndPiggyBank(Long value, Long piggyBankId);

}
