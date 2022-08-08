package com.amazingavocado.holymolymvp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;

@Data
@Getter
@Setter
// 주문 건 관련 저장 -
public class ReservationOrder2Vo {

    private Long userId;

    private Long filterId;

    private Long shopId;

    private Long itemId;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" ,timezone = "Asia/Seoul")

    private String reservationPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationPickupDate;

    private String reservationPickupTime;


    //새정보
    private String reservationAdding;

    private String reservationSituation;

    private String reservationMsgCard;

    SimpleDateFormat simpledateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
}