package co.crisi.piggybank.service.model;

import co.crisi.piggybank.data.CoinDto;
import co.crisi.piggybank.data.PiggyBankDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.val;

public final class CoinDtoMother {

    private static final Random RANDOM = new Random();

    public static CoinDto getRandomCoin(PiggyBankDto piggyBankDto) {
        return new CoinDto(null, RANDOM.nextLong(), RANDOM.nextLong(), piggyBankDto);
    }

    public static CoinDto getSavedCoin(CoinDto newCoin) {
        return new CoinDto(RANDOM.nextLong(), newCoin.value(), newCoin.amount(), newCoin.piggyBank());
    }

    public static List<CoinDto> getRandomCoins(PiggyBankDto piggyBankDto) {
        val coins = new ArrayList<CoinDto>();
        coins.add(getRandomCoin(piggyBankDto));
        coins.add(getRandomCoin(piggyBankDto));
        coins.add(getRandomCoin(piggyBankDto));
        return coins;
    }

}
