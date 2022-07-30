package com.amazingavocado.holymolymvp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDto {

    private Long id;

    private int age;

    private int gender;

    private String region;

    public UserDto(int age, int gender, String region) {
        this.age = age;
        this.gender = gender;
        this.region = region;
    }
}
