package gr.aueb.cf.schoolapp.repository;

import gr.aueb.cf.schoolapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> findByAfm(String vat);
    Optional<User> findByUsername(String username);
}
