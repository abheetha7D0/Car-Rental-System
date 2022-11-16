package lk.carrental.carrental.repo;

import lk.carrental.carrental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepo extends JpaRepository<Driver, String> {

    @Query(value = " select * from driver order by rand() limit 1; ", nativeQuery = true)
    Driver findDriverRandomly();
}
