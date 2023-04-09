package co.crisi.piggybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "co.crisi.piggybank")
public class PiggyBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiggyBankApplication.class, args);
    }

}
