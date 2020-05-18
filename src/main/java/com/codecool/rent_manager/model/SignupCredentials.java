package com.codecool.rent_manager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignupCredentials {

    String username;
    String password;
    Role role;
}
