package com.amazingavocado.holymolymvp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    // 꽃 시작 가격
    @Column(name = "item_start_price", nullable = false)
    private int itemStartPrice;

    // 꽃 시작 가격
    @Column(name = "item_end_price", nullable = false)
    private int itemEndPrice;

    // 꽃 설명
   @Column(name = "item_desc", nullable = false)
    private String itemDesc;

    // 꽃 색상
    @Column(name = "item_color", nullable = false)
    private String itemColor;

    // 꽃 이미지
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> itemImage = new ArrayList<>();

    // Item에서 Image 처리 위함
    public void addItemImage(Image image) {
        this.itemImage.add(image);

        // Item에 Image가 저장되어있지 않은 경우
        if(image.getItem() != this)
            // Image 저장
            image.setItem(this);
    }

}
