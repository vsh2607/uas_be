
package uas.co.id.uas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uas.co.id.uas.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
