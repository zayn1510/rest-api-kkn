package com.api.kkn.app.services;
import com.api.kkn.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDetailsService userDetailsService(){
        return username -> userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
}
