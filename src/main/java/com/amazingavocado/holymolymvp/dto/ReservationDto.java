package com.amazingavocado.holymolymvp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;


@Data
@Getter
@Setter
public class ReservationDto {

    private Long userId;

    private Long filterId;

    private Long shopId;

    private Long itemId;

    //
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" ,timezone = "Asia/Seoul")

    private String reservationPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationPickupDate;

     private String reservationPickupTime;

     //
     private String reservationAdding;

    private String reservationMsgCard;

    private String reservationSituation;

     SimpleDateFormat simpledateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

     //
     private String reservationOrdererName;

     private String reservationOrdererPhone;

     private String reservationTerm;
}
