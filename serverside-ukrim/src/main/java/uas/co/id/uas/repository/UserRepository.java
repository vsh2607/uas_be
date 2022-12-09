
package uas.co.id.uas.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uas.co.id.uas.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
    // SELECT * FROM USER WHERE USERNAME = ?
}
