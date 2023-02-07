package co.crisi.piggybank.repository;

import co.crisi.piggybank.entity.PiggyBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiggyBankRepository extends PagingAndSortingRepository<PiggyBank, Long>,
        JpaRepository<PiggyBank, Long> {

}
