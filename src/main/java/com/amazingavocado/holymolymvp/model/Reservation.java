package com.amazingavocado.holymolymvp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

// 예약내역
public class Reservation extends Timestamped {

    // PK 예약id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reservation_id")
    private Long id;

    //FK 필터링id
    @ManyToOne
    @JoinColumn(name = "filter_id", nullable = false)
    private Filter filter;

    // FK 유저id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //FK 아이템id
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    // 가격
    @Column(name = "reservation_price", nullable = false)
    private String reservationPrice;

    // 픽업 날짜
    @Column(name = "reservation_pickup_date", nullable = false)
    private Date reservationPickupDate;

    // 픽업 시간
    @Column(name = "reservation_pickup_time", nullable = false)
    private Time reservationPickupTime;

    // 추가 입력 사항 null
    @Column(name = "reservation_adding")
    private String reservationAdding;

    // 선물 상황 null
    @Column(name = "reservation_situation")
    private String reservationSituation;

    // 이름
    @Column(name = "reservation_orderer_name", nullable = false)
    private String reservationOrdererName;

    // 전화번호
    @Column(name = "reservation_orderer_phone", nullable = false)
    private String reservationOrdererPhone;

    // 생성 날짜
    @Column(name = "reservation_create_date", nullable = false)
    private DateTime reservationCreateDate;
}