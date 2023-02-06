package co.crisi.piggybank.service.model;

import co.crisi.piggybank.data.PiggyBankDto;
import java.util.ArrayList;
import java.util.Random;
import lombok.val;

public class PiggyBankMother {

    private static final Random RANDOM = new Random();

    public static PiggyBankDto getRandomPiggyBank() {
        val piggyBankDto = new PiggyBankDto(RANDOM.nextLong(), new ArrayList<>());
        piggyBankDto.coins()
                .addAll(CoinDtoMother.getRandomCoins(piggyBankDto));
        return piggyBankDto;
    }

    public static PiggyBankDto getRandomPiggyBankWithEmptyCoins(){
        return new PiggyBankDto(RANDOM.nextLong(), new ArrayList<>());
    }

}
