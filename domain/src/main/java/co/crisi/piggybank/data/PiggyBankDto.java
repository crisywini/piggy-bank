package co.crisi.piggybank.data;

import java.util.List;

public record PiggyBankDto(Long id, List<CoinDto> coins) {

}
