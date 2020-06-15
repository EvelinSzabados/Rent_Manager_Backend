package com.codecool.rent_manager.controller;

import com.codecool.rent_manager.model.AppUser;
import com.codecool.rent_manager.model.Role;
import com.codecool.rent_manager.model.SignupCredentials;
import com.codecool.rent_manager.model.UserCredentials;
import com.codecool.rent_manager.repository.AppUserRepository;
import com.codecool.rent_manager.security.JwtUtil;
import com.codecool.rent_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;
    @Autowired
    AppUserRepository appUserRepository;

    @PostMapping("/login")
    public ResponseEntity<AppUser> login(@RequestBody UserCredentials appUser, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                appUser.getUsername(),
                appUser.getPassword()
        ));
        String jwtToken = jwtUtil.generateToken(authentication);
        addTokenToCookie(response, jwtToken);
        AppUser userInDb = appUserRepository.findByUserName(appUser.getUsername());
        return ResponseEntity.ok().body(userInDb);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupCredentials credentials) {
        userService.register(credentials.getUsername(),credentials.getPassword(),credentials.getRole());
        return ResponseEntity.status(HttpStatus.CREATED).body(credentials.getUsername());
    }

    private void addTokenToCookie(HttpServletResponse response, String token) {
        ResponseCookie cookie = ResponseCookie.from("token", token)
                .domain("rent-manager.netlify.app") // should be parameterized
                .sameSite("Strict")  // CSRF
//                .secure(true)
                .maxAge(Duration.ofHours(24))
                .httpOnly(true)      // XSS
                .path("/")
                .build();
        response.addHeader("Set-Cookie", cookie.toString());


    }

    @PostMapping("/logout")
    public void logout(HttpServletResponse response,HttpServletRequest request){
        Optional<Cookie> jwtToken =
                Arrays.stream(Optional.ofNullable(request.getCookies()).orElse(new Cookie[]{}))
                        .filter(cookie -> cookie.getName().equals("token"))
                        .findFirst();
        ResponseCookie cookie = ResponseCookie.from("token", jwtToken.toString())
                .domain("rent-manager.netlify.app")
                .sameSite("Strict")
                .maxAge(0)
                .httpOnly(true)
                .path("/")
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
//        response.addHeader("Access-Control-Allow-Origin", "http://rent-manager.netlify.app");
//        response.addHeader("Access-Control-Allow-Credentials", "true");
//        response.addHeader("Access-Control-Allow-Methods", "GET, POST,PUT,DELETE");
//        response.addHeader("Access-Control-Allow-Headers"," Content-Type, *");;
    }
    @GetMapping("/me")
    public Boolean currentUser(HttpServletRequest request) {
        Optional<Cookie> jwtToken =
                Arrays.stream(Optional.ofNullable(request.getCookies()).orElse(new Cookie[]{}))
                        .filter(cookie -> cookie.getName().equals("token"))
                        .findFirst();
        if (jwtToken.isPresent()) {
        UsernamePasswordAuthenticationToken userToken = jwtUtil.validateTokenAndExtractUserSpringToken(jwtToken.get().getValue());
        SecurityContextHolder.getContext().setAuthentication(userToken);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return authentication.isAuthenticated();

        }
        return false;

    }

    @GetMapping("/getUser")
    public AppUser getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser userInDb = appUserRepository.findByUserName(authentication.getPrincipal().toString());
        return userInDb;
    }


}

