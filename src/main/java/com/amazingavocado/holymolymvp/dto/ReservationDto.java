package com.amazingavocado.holymolymvp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;


@Data
public class ReservationDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" ,timezone = "Asia/Seoul")

    private String price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pickup_date;
    @DateTimeFormat(pattern = "HH:mm")
    private Date pickup_time;


    SimpleDateFormat simpledateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
    SimpleDateFormat simpletimeFormat = new SimpleDateFormat("HH시 mm분");

    public ReservationDto(String price, Date pickup_date, Date pickup_time) {
        this.price = price;
        this.pickup_date = pickup_date;
        this.pickup_time = pickup_time;
    }


    @Override
    public String toString() {
        String pickupDate2 = simpledateFormat.format(pickup_date);
        String pickupTime2 = simpletimeFormat.format(pickup_time);

        return "orderForm{" +
                "price='" + price + '\'' +
                ", pickup_date='" + pickupDate2 + '\'' +
                ", pickup_date='" + pickupTime2 + '\'' +
                '}';
    }

}
