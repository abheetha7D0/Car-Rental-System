package lk.carrental.carrental.repo;


import lk.carrental.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {

}
