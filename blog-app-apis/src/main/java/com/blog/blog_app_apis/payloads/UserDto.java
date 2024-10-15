package com.blog.blog_app_apis.payloads;

import org.hibernate.annotations.SecondaryRow;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be min of 4 charachters")
    private String name;

    @Email(message = "Email address is not valid")
    private String email;

    @NotEmpty
    @Size(message = "Password must be min of 4 characters", min = 4)
    private String password;

    @NotEmpty
    private String about;

}
