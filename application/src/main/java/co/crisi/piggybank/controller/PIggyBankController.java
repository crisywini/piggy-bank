package co.crisi.piggybank.controller;

import co.crisi.piggybank.data.PiggyBankDto;
import co.crisi.piggybank.port.api.PiggyBankServicePort;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/piggy-banks")
public class PIggyBankController {

    @Autowired
    private PiggyBankServicePort piggyBankServicePort;

    @PostMapping
    public ResponseEntity<PiggyBankDto> save(
            @RequestBody
                    PiggyBankDto piggyBankDto) {
        return new ResponseEntity<>(piggyBankServicePort.save(piggyBankDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PiggyBankDto> findById(
            @PathVariable(name = "id")
                    Long id) {
        return new ResponseEntity<>(piggyBankServicePort.findById(id), HttpStatus.OK);
    }

    @PatchMapping("/close/{id}")
    public ResponseEntity<Void> close(
            @PathVariable
                    Long id) {
        piggyBankServicePort.close(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/total/{id}")
    public ResponseEntity<Long> findTotal(
            @PathVariable(name = "id")
                    Long id,
            @RequestParam(required = false)
                    Long value) {
        return new ResponseEntity<>(Objects.isNull(value) ? piggyBankServicePort.getTotal(id)
                : piggyBankServicePort.findCoinAmountByValueAnPiggyBankId(value, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable(name = "id")
                    Long id) {
        piggyBankServicePort.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
