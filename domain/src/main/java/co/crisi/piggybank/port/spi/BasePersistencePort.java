package co.crisi.piggybank.port.spi;

import java.util.List;
import java.util.Optional;

public interface BasePersistencePort<T, S> {

    T save(T entity);

    Optional<T> findById(S id);

    void deleteById(S id);

    List<T> findAll();

}
