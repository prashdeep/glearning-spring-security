package com.glearning.ssecurity.service;

import com.glearning.ssecurity.model.CustomUserDetails;
import com.glearning.ssecurity.model.User;
import com.glearning.ssecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUserName(username);

        if ( user == null) {
            throw new UsernameNotFoundException("User is not present");
        }
        CustomUserDetails userDetails = new CustomUserDetails(user);
        return userDetails;
    }
}