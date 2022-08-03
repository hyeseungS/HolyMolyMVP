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
// 이미지
public class Image {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "image_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(nullable = false)
    private String imagePath;

    // Item 정보 저장
    public void setItem(Item item){
        this.item = item;

        // Item에 현재 Image가 존재하지 않는다면
        if(!item.getItemImage().contains(this))
            // Image 추가
            item.getItemImage().add(this);
    }
}
