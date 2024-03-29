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

    // 꽃집 주소
    @Column(name = "shop_address", nullable = false)
    private String shopAddress;

    // 꽃집 주소 코드
    @Column(name = "shop_address_code", nullable = false)
    private String shopAddressCode;

    // 꽃집 전화번호
    @Column(name = "shop_phone")
    private String shopPhone;

    // 영업 시간
    @Column(name = "shop_time")
    private String shopTime;

    // 꽃집 이미지
    @Column(name = "shop_image")
    private String shopImage;

    // 꽃집 배경 이미지
    @Column(name = "shop_bg_image")
    private String shopBgImage;

    // 꽃집 주소 링크
    @Column(name = "shop_link")
    private String shopLink;

    // 꽃집 가까운 역
    @Column(name = "shop_station")
    private String shopStation;

    // 꽃집 도보 또는 자동차
    @Column(name = "shop_route")
    private String shopRoute;

    // 꽃집 가까운 역 거리
    @Column(name = "shop_distance")
    private String shopDistance;
}

