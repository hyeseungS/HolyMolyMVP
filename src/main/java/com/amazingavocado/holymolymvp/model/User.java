package com.amazingavocado.holymolymvp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// 회원 기본 정보
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private Long id;

    // 나이
    @Column(name = "age", nullable = false)
    private int age;

    // 성별
    @Column(name = "gender", nullable = false)
    private int gender;

    // 지역
    @Column(name = "region", nullable = false)
    private String region;
}

