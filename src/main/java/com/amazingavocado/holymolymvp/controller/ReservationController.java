package com.amazingavocado.holymolymvp.controller;

import com.amazingavocado.holymolymvp.dto.ReservationDto;
import com.amazingavocado.holymolymvp.dto.ReservationIdVo;
import com.amazingavocado.holymolymvp.dto.ReservationOrderVo;
import com.amazingavocado.holymolymvp.model.Reservation;
import com.amazingavocado.holymolymvp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    //예약 시작 페이지
    @PostMapping("/order")
    public String createOrder(ReservationIdVo reservationIdVo, Model model) {

        // id 정보 넘기기
        model.addAttribute("userId", reservationIdVo.getUserId());
        model.addAttribute("filterId", reservationIdVo.getFilterId());
        model.addAttribute("shopId", reservationIdVo.getShopId());
        model.addAttribute("itemId", reservationIdVo.getItemId());

        System.out.println("두번째");
        System.out.println(reservationIdVo.getUserId());
        System.out.println(reservationIdVo.getFilterId());
        System.out.println(reservationIdVo.getShopId());
        System.out.println(reservationIdVo.getItemId());

        return "order_info";
    }

    //주문자정보 페이지
    @PostMapping("/orderer")
    public String orderer(ReservationOrderVo reservationOrderVo, Model model) {

        // id 정보 넘기기
        model.addAttribute("userId", reservationOrderVo.getUserId());
        model.addAttribute("filterId", reservationOrderVo.getFilterId());
        model.addAttribute("shopId", reservationOrderVo.getShopId());
        model.addAttribute("itemId", reservationOrderVo.getItemId());

        //order 정보 넘기기
        model.addAttribute("reservationPrice", reservationOrderVo.getReservationPrice());
        model.addAttribute("reservationPickupDate", reservationOrderVo.getReservationPickupDate());
        model.addAttribute("reservationPickupTime", reservationOrderVo.getReservationPickupTime());
        model.addAttribute("reservationAdding", reservationOrderVo.getReservationAdding());
        model.addAttribute("reservationSituation", reservationOrderVo.getReservationSituation());


        System.out.println("세번째");
        System.out.println(reservationOrderVo.getUserId());
        System.out.println(reservationOrderVo.getFilterId());
        System.out.println(reservationOrderVo.getShopId());
        System.out.println(reservationOrderVo.getItemId());
        System.out.println(reservationOrderVo.getReservationPrice());
        System.out.println(reservationOrderVo.getReservationPickupDate());
        System.out.println(reservationOrderVo.getReservationPickupTime());
        System.out.println(reservationOrderVo.getReservationAdding());
        System.out.println(reservationOrderVo.getReservationSituation());

        return "orderer_info";
    }

    //전송하기 페이지(modal) -> 저장
    @PostMapping("/order-complete")
    public String sendorder(ReservationDto reservationDto) {

        //주문내역 저장
        Reservation reservation;

        /*
        reservation = reservationService.saveReservation(reservationDto);
         */

        return "order_complete";
    }
}