package co.crisi.piggybank.adapter;

import co.crisi.piggybank.data.PiggyBankDto;
import co.crisi.piggybank.exception.ResourceNotFoundException;
import co.crisi.piggybank.mapper.PiggyBankMapper;
import co.crisi.piggybank.port.spi.PiggyBankPersistencePort;
import co.crisi.piggybank.repository.PiggyBankRepository;
import java.util.List;
import java.util.Optional;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PiggyBankJpaAdapter implements PiggyBankPersistencePort {

    @Autowired
    private PiggyBankRepository piggyBankRepository;

    private final PiggyBankMapper piggyBankMapper = Mappers.getMapper(PiggyBankMapper.class);

    @Override
    public PiggyBankDto save(PiggyBankDto entity) {
        return piggyBankMapper.mapToDto(piggyBankRepository.save(piggyBankMapper.mapToEntity(entity)));
    }

    @Override
    public Optional<PiggyBankDto> findById(Long id) {
        return Optional.ofNullable(
                piggyBankMapper.mapToDto(piggyBankRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                String.format("Could not find the piggy bank %d", id)))));
    }

    @Override
    public void deleteById(Long id) {
        piggyBankRepository.deleteById(id);
    }

    @Override
    public List<PiggyBankDto> findAll() {
        return piggyBankMapper.mapToDtos(piggyBankRepository.findAll());
    }

}
