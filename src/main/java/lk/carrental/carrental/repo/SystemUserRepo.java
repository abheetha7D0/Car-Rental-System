package lk.carrental.carrental.repo;

import lk.carrental.carrental.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRepo extends JpaRepository<SystemUser, String> {
}
