package br.com.willbigas.circuitbreakerspringbootsecondms.repository;

import br.com.willbigas.circuitbreakerspringbootsecondms.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	Optional<Order> findByOrderNumber(String orderNumber);
}
