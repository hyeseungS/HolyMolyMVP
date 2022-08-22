package com.amazingavocado.holymolymvp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import javax.persistence.*;

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

/* FK 말고 id만 받아오는 Long으로 해볼게요
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
    */

    //유저id
    @Column(name = "user_id", nullable = false)
    private Long userId;

    //필터링id
    @Column(name = "filter_id", nullable = false)
    private Long filterId;

    //가게id
    @Column(name = "shop_id", nullable = false)
    private Long shopId;

    //상품id
    @Column(name = "item_id", nullable = false)
    private Long itemId;


    // 가격
    @Column(name = "reservation_price", nullable = false)
    private String reservationPrice;

    //수령 방식
    @Column (name = "reservation_way", nullable = false)
    private String reservationWay;

    //배달일 경우- 수령주소
    @Column (name = "reseration_delivery_address")
    private String reservationDeliveryAddress;
*/

    // 픽업 날짜
    @Column(name = "reservation_pickup_date", nullable = false)
    private String reservationPickupDate;

    // 픽업 시간
    @Column(name = "reservation_pickup_time", nullable = false)
    private String reservationPickupTime;



    // 추가 입력 사항 null
    @Column(name = "reservation_adding")
    private String reservationAdding;

    // 메세지 카드 null
    @Column(name = "reservation_msg_card")
    private String reservationMsgCard;

    // 선물 상황 null
    @Column(name = "reservation_situation")
    private String reservationSituation;

    // 쿠폰 번호
    @Column (name = "reservation_coupon")
    private String reservationCoupon;

    // 이름
    @Column(name = "reservation_orderer_name", nullable = false)
    private String reservationOrdererName;

    // 전화번호
    @Column(name = "reservation_orderer_phone", nullable = false)
    private String reservationOrdererPhone;

    // 약관 선택 동의 체크 null
    @Column(name = "reservaion_term")
    private String reservationTerm;

    // 생성 날짜
    @Column(name = "reservation_create_date", nullable = false)
    private LocalDateTime reservationCreateDate;
    @PrePersist
    public void createDate() {
        this.reservationCreateDate = LocalDateTime.now();
    }
}