package co.crisi.piggybank.adapter;

import co.crisi.piggybank.data.CoinDto;
import co.crisi.piggybank.exception.ResourceNotFoundException;
import co.crisi.piggybank.mapper.CoinMapper;
import co.crisi.piggybank.port.spi.CoinPersistencePort;
import co.crisi.piggybank.repository.CoinRepository;
import java.util.List;
import java.util.Optional;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoinJpaAdapter implements CoinPersistencePort {

    @Autowired
    private CoinRepository coinRepository;

    private final CoinMapper coinMapper = Mappers.getMapper(CoinMapper.class);

    @Override
    public CoinDto save(CoinDto entity) {
        return coinMapper.mapToDto(coinRepository.save(coinMapper.mapToEntity(entity)));
    }

    @Override
    public Optional<CoinDto> findById(Long id) {
        return Optional.ofNullable(
                coinMapper.mapToDto(coinRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                String.format("Could not find a coin with id %d", id)))));
    }

    @Override
    public void deleteById(Long id) {
        coinRepository.deleteById(id);
    }

    @Override
    public List<CoinDto> findAll() {
        return coinMapper.mapToDtos(coinRepository.findAll());
    }

    @Override
    public List<CoinDto> findAllByPiggyBankId(Long piggyBankId) {
        return coinMapper.mapToDtos(coinRepository.findAllByPiggyBankId(piggyBankId));
    }

}
