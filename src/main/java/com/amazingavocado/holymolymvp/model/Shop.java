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
// 꽃집 정보
public class Shop {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "shop_id")
    private Long id;

    // 꽃집 이름
    @Column(name = "shop_name", nullable = false)
    private String shopName;

    // 꽃집 위치
    @Column(name = "shop_address", nullable = false)
    private String shopAddress;

    // 영업 시간
    @Column(name = "shop_time", nullable = false)
    private String shopTime;

    // 꽃집 이미지
    @Column(name = "shop_image")
    private String shopImage;

    // 꽃집 배경 이미지
    @Column(name = "shop_bg_image")
    private String shopBgImage;
}
