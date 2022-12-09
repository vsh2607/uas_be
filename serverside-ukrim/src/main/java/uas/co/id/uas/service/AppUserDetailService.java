
package uas.co.id.uas.service;

import lombok.AllArgsConstructor;
import uas.co.id.uas.model.AppUserDetail;
import uas.co.id.uas.model.User;
import uas.co.id.uas.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AppUserDetailService implements UserDetailsService{
    
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username).
                orElseThrow(()-> new UsernameNotFoundException("Username or password is not correct"));
        return new AppUserDetail(user);
    }
    
}
