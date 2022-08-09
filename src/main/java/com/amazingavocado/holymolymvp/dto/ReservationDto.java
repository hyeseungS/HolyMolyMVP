package com.amazingavocado.holymolymvp.dto;

import com.amazingavocado.holymolymvp.model.Reservation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.text.SimpleDateFormat;


@Data
@Getter
@Setter
public class ReservationDto {

    private Long userId;

    private Long filterId;

    private Long shopId;

    private Long itemId;


    private String reservationPrice;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" ,timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationPickupDate;

     private String reservationPickupTime;

     //
     private String reservationAdding;

    private String reservationSituation;

    private String reservationMsgCard;


     //
     private String reservationOrdererName;

     private String reservationOrdererPhone;

     private String reservationTerm;

     /*
     public Reservation toEntity() {
         return new Reservation(null,userId, filterId, shopId, itemId,
                 reservationPrice, reservationPickupDate,reservationPickupTime,
                 reservationAdding, reservationMsgCard, reservationSituation,
                 reservationOrdererName, reservationOrdererPhone, reservationTerm, null);

     }
     */
}
