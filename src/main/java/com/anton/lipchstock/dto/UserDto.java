package com.anton.lipchstock.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String login;
    private String password;
}
