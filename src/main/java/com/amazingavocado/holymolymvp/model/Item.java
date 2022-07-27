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
// 꽃 정보
public class Item {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    // 꽃 이름
    @Column(name = "item_name", nullable = false)
    private String itemName;

    // 꽃 가격
    @Column(name = "item_price", nullable = false)
    private String itemPrice;

    // 꽃 설명
   @Column(name = "item_desc", nullable = false)
    private String itemDesc;

   // 꽃 색상
    @Column(name = "item_color", nullable = false)
    private String itemColor;

    // 꽃 카테고리
    @Column(name = "item_category", nullable = false)
    private String itemCategory;

    // 꽃 이미지
    @Column(name = "item_image", nullable = false)
    private String itemImage;

}
