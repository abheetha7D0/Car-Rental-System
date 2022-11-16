package lk.carrental.carrental.repo;

import lk.carrental.carrental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, String> {

}
