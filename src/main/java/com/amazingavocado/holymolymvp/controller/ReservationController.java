package com.amazingavocado.holymolymvp.controller;

import com.amazingavocado.holymolymvp.dto.ReservationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {

    //예약안내 페이지(modal)
    @GetMapping("/order-start")
    public String orderStart() {
        return "alert_start";
    }


    //주문정보 페이지
    @GetMapping("/order")
    public String order() {
        //templates 폴더의 "order_info"파일이 열린다.
        return "order_info";
    }

    @PostMapping("/order")
    public String neworder(ReservationDto orderDto) {
        System.out.println(orderDto.toString());
        return "";
    }

    //주문자정보 페이지
    @PostMapping("/orderer")
    public String orderer() {
        return "orderer_info";
    }

    @GetMapping("/qq")
    public String qq() {
        return "test";
    }

    //전송하기 페이지(modal)
    @PostMapping("/order-send")
    public String sendorder() {
        return "alert_send";
    }

    //예약요청완료 페이지
    @PostMapping("/order-complete")
    public String orderComplete() {
        return "order_complete";
    }

}