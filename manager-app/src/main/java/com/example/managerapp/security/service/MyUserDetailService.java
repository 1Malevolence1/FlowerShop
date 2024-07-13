package com.example.managerapp.security.service;


import com.example.managerapp.security.model.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {


    public final MyUserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           MyUser user = service.findByUser(username);
           return User.builder().username(user.getUsername()).password(user.getPassword()).roles(user.getRole()).build();
    }
}
