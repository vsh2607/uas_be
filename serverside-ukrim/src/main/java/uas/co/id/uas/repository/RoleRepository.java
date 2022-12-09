
package uas.co.id.uas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uas.co.id.uas.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
