package co.crisi.piggybank.port.spi;

import java.util.List;

public interface BasePersistencePort<T, S> {

    T save(T entity);

    T findById(S id);

    void deleteById(S id);

    List<T> findAll();

    T update(S id, T newInfoEntity);

}
