package hello.tricountpractice.repository;

import hello.tricountpractice.model.entity.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementRepository extends JpaRepository<Settlement, Long> {
}
