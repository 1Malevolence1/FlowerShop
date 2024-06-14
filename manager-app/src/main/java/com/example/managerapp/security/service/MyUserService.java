package com.example.managerapp.security.service;

import com.example.clientapp.security.dto.DtoMyUser;
import com.example.clientapp.security.exeption.UsernameFoundInBaseDate;
import com.example.clientapp.security.model.MyUser;
import com.example.clientapp.security.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyUserService {

    private final MyUserRepository myUserRepository;
    private final PasswordEncoder passwordEncoder;
    public MyUser findByUser(String username) throws UsernameNotFoundException {
        return myUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public void save(DtoMyUser dto){
        checkUsernameInBaseDate(dto.getUsername());
        MyUser myUser = buildMyUser(dto);
        myUserRepository.save(myUser);
        log.info("Пользователь добавлен");
    }


    private String passwordEncoder(String password){
        return passwordEncoder.encode(password);
    }

    private void checkUsernameInBaseDate(String username) {
        if (myUserRepository.findByUsername(username).isPresent()) {
            throw new UsernameFoundInBaseDate("Данный логин зантя. Придумкайте дургой лоигни");
        }
    }

    public MyUser buildMyUser(DtoMyUser dto){
        MyUser myUser = new MyUser(null, dto.getUsername(), dto.getPassword(), dto.getRole());
        myUser.setRole("USER");
        myUser.setPassword(passwordEncoder(myUser.getPassword()));
        return myUser;
    }
}

