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
// 예약내역
public class Reservation extends Timestamped {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 가격
    @Column(name = "reservation_price", nullable = false)
    private String reservationPrice;

    // 픽업 날짜
    @Column(name = "reservation_pickup_date", nullable = false)
    private String reservationPickupDate;

    // 픽업 시간
    @Column(name = "reservation_pickup_time", nullable = false)
    private String reservationPickupTime;

    // 이름
    @Column(name = "reservation_username", nullable = false)
    private String reservationUsername;

    // 전화번호
    @Column(name = "reservation_phone", nullable = false)
    private String reservationPhone;

    // 추가사항
    @Column(name = "reservation_detail")
    private String reservationDetail;
}
