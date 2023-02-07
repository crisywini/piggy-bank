package co.crisi.piggybank.controller;

import co.crisi.piggybank.data.CoinDto;
import co.crisi.piggybank.port.api.CoinServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coins")
public class CoinController {

    @Autowired
    private CoinServicePort coinServicePort;

    @PostMapping
    public ResponseEntity<Long> save(
            @RequestBody
                    CoinDto coinDto) {
        return new ResponseEntity<>(coinServicePort.save(coinDto).id(), HttpStatus.CREATED);
    }

}
