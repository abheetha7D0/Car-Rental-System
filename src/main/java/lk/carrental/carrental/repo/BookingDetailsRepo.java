package lk.carrental.carrental.repo;

import lk.carrental.carrental.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface BookingDetailsRepo extends JpaRepository<BookingDetails, String> {

}
