package com.codecool.rent_manager.security;

import com.codecool.rent_manager.model.AppUser;
import com.codecool.rent_manager.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository
                .findByUsername(username);
        if(appUser == null){
            throw new UsernameNotFoundException("User not found: " + username);
        }
//                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new User(
                appUser.getUserName(),
                appUser.getHashedPassword(),
                appUser.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                        .collect(Collectors.toList())
        );
    }
}
