package com.cubeapp.cubeapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {
    @Id
    private long id;

    @NotBlank
    @Size(max = 40)
    private String name;

    @Size(max = 40)
    private String address;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;
}