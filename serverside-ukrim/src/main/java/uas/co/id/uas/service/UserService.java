
package uas.co.id.uas.service;

import java.util.List;
import lombok.AllArgsConstructor;
import uas.co.id.uas.model.User;
import uas.co.id.uas.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "User id not found"
                        ));
    }

    public User create(User user) {
        user.getEmployee().setUser(user);
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        getById(id);
        user.setId(id);
        return userRepository.save(user);
    }

    public User delete(Long id) {
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }
}
