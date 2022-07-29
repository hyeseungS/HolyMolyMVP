package com.amazingavocado.holymolymvp.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class UserDto {

    private String age;

    private String gender;

    private String region;
}
