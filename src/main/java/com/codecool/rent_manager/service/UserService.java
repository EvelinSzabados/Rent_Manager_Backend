package com.codecool.rent_manager.service;

import com.codecool.rent_manager.model.AppUser;
import com.codecool.rent_manager.model.Role;
import com.codecool.rent_manager.model.UserCredentials;
import com.codecool.rent_manager.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {


    private final AppUserRepository appUserRepository;
    private final PasswordEncoder encoder;

    public AppUser register(String username, String password, Set<Role> roles) {
        return appUserRepository.save(
                AppUser.builder()
                        .userName(username)
                        .hashedPassword(encoder.encode(password))
                        .roles(roles)
                        .build()
        );
    }

    public AppUser register(String username, String password) {
        return appUserRepository.save(
                AppUser.builder()
                        .userName(username)
                        .hashedPassword(encoder.encode(password))
                        .role(Role.ADMIN)
                        .build()
        );
    }

    public AppUser register (UserCredentials userCredentials) {
        return register(userCredentials.getUsername(), userCredentials.getPassword());
    }

}
