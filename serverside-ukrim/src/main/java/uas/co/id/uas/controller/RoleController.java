
package uas.co.id.uas.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import uas.co.id.uas.model.Role;
import uas.co.id.uas.service.RoleService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/role")
public class RoleController {
    
    private RoleService roleService;
    
    @GetMapping
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable Long id) {
      return roleService.getById(id);
    }

    @PostMapping
    public Role create(@RequestBody Role role) {
        return roleService.create(role);
    }

    @PutMapping("/{id}")
    public Role update(@PathVariable Long id, @RequestBody Role role) {
       return roleService.update(id, role);
    }

    @DeleteMapping("/{id}")
    public Role delete(@PathVariable Long id) {
      return roleService.delete(id);
    }
    
}
