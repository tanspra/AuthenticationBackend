package com.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
public class RegistrationDTO {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Registration Info {" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
