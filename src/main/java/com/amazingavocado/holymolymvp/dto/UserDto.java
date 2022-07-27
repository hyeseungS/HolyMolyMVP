package com.amazingavocado.holymolymvp.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class UserDto {

    private int age;

    private int gender;

    private int region;
}
