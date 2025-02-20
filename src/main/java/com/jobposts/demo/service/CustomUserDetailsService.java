package com.jobposts.demo.service;

import com.jobposts.demo.entities.Users;
import com.jobposts.demo.repository.UsersRepository;
import com.jobposts.demo.util.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Could not find: " + username));
        return new CustomUserDetails(users);
    }
}
