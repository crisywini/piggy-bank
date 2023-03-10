package co.crisi.piggybank.repository;

import co.crisi.piggybank.entity.Coin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepository extends PagingAndSortingRepository<Coin, Long>, JpaRepository<Coin, Long> {

    List<Coin> findAllByPiggyBankId(Long piggyBankId);

}
