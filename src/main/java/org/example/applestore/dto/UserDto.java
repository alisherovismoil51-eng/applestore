package org.example.applestore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createddate = LocalDateTime.now();
    private String cartid;
}
