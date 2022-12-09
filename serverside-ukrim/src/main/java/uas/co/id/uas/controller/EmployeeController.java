
package uas.co.id.uas.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import uas.co.id.uas.model.Employee;
import uas.co.id.uas.service.EmployeeService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class EmployeeController {

    private EmployeeService employeeService;

    /**
     * @return
     */
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PreAuthorize("hasAuthority('READ_MANAGER')")
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PreAuthorize("hasAuthority('CREATE_USER')")
    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public Employee delete(@PathVariable Long id) {
        return employeeService.delete(id);
    }

}
