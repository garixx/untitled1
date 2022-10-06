package org.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class LoginDto {
    private String username;
    private String password;
}
