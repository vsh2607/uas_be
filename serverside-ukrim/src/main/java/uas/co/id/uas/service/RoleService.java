
package uas.co.id.uas.service;

import java.util.List;
import lombok.AllArgsConstructor;
import uas.co.id.uas.model.Role;
import uas.co.id.uas.repository.RoleRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@AllArgsConstructor
public class RoleService {

    private RoleRepository roleRepository;

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role getById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Role id not found"
                        ));
    }

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public Role update(Long id, Role role) {
        getById(id);
        role.setId(id);
        return roleRepository.save(role);
    }

    public Role delete(Long id) {
        Role role = getById(id);
        roleRepository.delete(role);
        return role;
    }

}
