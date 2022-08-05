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
// 필터링 내역
public class Filter extends Timestamped {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "filter_id")
    private Long filter_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 필터링 색상
    @Column(name = "filter_color")
    private String filterColor;

    // 필터링 시작 가격
    @Column(name = "filter_start_price")
    private int filterStartPrice;

    // 필터링 끝 가격
    @Column(name = "filter_end_price")
    private int filterEndPrice;

}
