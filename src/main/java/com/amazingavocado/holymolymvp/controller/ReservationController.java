package com.amazingavocado.holymolymvp.controller;

import com.amazingavocado.holymolymvp.dto.ReservationDto;
import com.amazingavocado.holymolymvp.dto.ReservationIdVo;
import com.amazingavocado.holymolymvp.dto.ReservationOrder2Vo;
import com.amazingavocado.holymolymvp.dto.ReservationOrder1Vo;
import com.amazingavocado.holymolymvp.model.Item;
import com.amazingavocado.holymolymvp.model.Reservation;
import com.amazingavocado.holymolymvp.service.ItemService;
import com.amazingavocado.holymolymvp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ItemService itemService;

    //예약 시작 페이지1
    @PostMapping("/order1")
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


    //예약 시작 페이지2
    @PostMapping("/order2")
    public String createOrder2(ReservationOrder1Vo reservationOrder1Vo, Model model) {

        // id 정보 넘기기
        model.addAttribute("userId", reservationOrder1Vo.getUserId());
        model.addAttribute("filterId", reservationOrder1Vo.getFilterId());
        model.addAttribute("shopId", reservationOrder1Vo.getShopId());
        model.addAttribute("itemId", reservationOrder1Vo.getItemId());

        //order1 정보 넘기기
        model.addAttribute("reservationPrice", reservationOrder1Vo.getReservationPrice());
        model.addAttribute("reservationPickupDate", reservationOrder1Vo.getReservationPickupDate());
        model.addAttribute("reservationPickupTime", reservationOrder1Vo.getReservationPickupTime());


        System.out.println("세번째");
        System.out.println(reservationOrder1Vo.getUserId());
        System.out.println(reservationOrder1Vo.getFilterId());
        System.out.println(reservationOrder1Vo.getShopId());
        System.out.println(reservationOrder1Vo.getItemId());
        System.out.println(reservationOrder1Vo.getReservationPrice());
        System.out.println(reservationOrder1Vo.getReservationPickupDate());
        System.out.println(reservationOrder1Vo.getReservationPickupTime());

        return "order_info2";
    }

    //주문자정보 페이지
    @PostMapping("/orderer")
    public String orderer(ReservationOrder2Vo reservationOrder2Vo, Model model) {

        // id 정보 넘기기
        model.addAttribute("userId", reservationOrder2Vo.getUserId());
        model.addAttribute("filterId", reservationOrder2Vo.getFilterId());
        model.addAttribute("shopId", reservationOrder2Vo.getShopId());
        model.addAttribute("itemId", reservationOrder2Vo.getItemId());

        //order1 정보 넘기기
        model.addAttribute("reservationPrice", reservationOrder2Vo.getReservationPrice());
        model.addAttribute("reservationPickupDate", reservationOrder2Vo.getReservationPickupDate());
        model.addAttribute("reservationPickupTime", reservationOrder2Vo.getReservationPickupTime());

        //order2 정보 넘기기
        model.addAttribute("reservationAdding", reservationOrder2Vo.getReservationAdding());
        model.addAttribute("reservationMsgCard", reservationOrder2Vo.getReservationMsgCard());
        model.addAttribute("reservationSituation", reservationOrder2Vo.getReservationSituation());


        System.out.println("네번째");
        System.out.println(reservationOrder2Vo.getUserId());
        System.out.println(reservationOrder2Vo.getFilterId());
        System.out.println(reservationOrder2Vo.getShopId());
        System.out.println(reservationOrder2Vo.getItemId());

        System.out.println(reservationOrder2Vo.getReservationPrice());
        System.out.println(reservationOrder2Vo.getReservationPickupDate());
        System.out.println(reservationOrder2Vo.getReservationPickupTime());

        System.out.println(reservationOrder2Vo.getReservationAdding());
        System.out.println(reservationOrder2Vo.getReservationMsgCard());
        System.out.println(reservationOrder2Vo.getReservationSituation());

        return "orderer_info";
    }

    @PostMapping("/order-sheet")
    public String sendOrder (ReservationDto reservationDto, Model model) {

        // id 정보 안념겯됨
        String itemName = itemService.getItemName(reservationDto.getItemId());
        String shopName = itemService.getShopName(reservationDto.getShopId());
        Item item = itemService.getItem(reservationDto.getItemId());

        model.addAttribute("reservationItemName", itemName);
        model.addAttribute("reservationShopName", shopName);
        model.addAttribute("item", item);

        //order1 정보 넘기기
        model.addAttribute("reservationPrice", reservationDto.getReservationPrice());
        model.addAttribute("reservationPickupDate", reservationDto.getReservationPickupDate());
        model.addAttribute("reservationPickupTime", reservationDto.getReservationPickupTime());

        //order2 정보 넘기기
        model.addAttribute("reservationAdding", reservationDto.getReservationAdding());
        model.addAttribute("reservationMsgCard", reservationDto.getReservationMsgCard());
        model.addAttribute("reservationSituation", reservationDto.getReservationSituation());

        //orderer 정보 넘기기
        model.addAttribute("reservationOrdererName", reservationDto.getReservationOrdererName());
        model.addAttribute("reservationOrdererPhone", reservationDto.getReservationOrdererPhone());
        model.addAttribute("reservationTerm", reservationDto.getReservationTerm());

        System.out.println("다섯번째");
        System.out.println(reservationDto.getReservationAdding());
        System.out.println(reservationDto.getReservationMsgCard());
        System.out.println(reservationDto.getReservationSituation());

        System.out.println(reservationDto.getReservationOrdererName());
        System.out.println(reservationDto.getReservationOrdererPhone());
        System.out.println(reservationDto.getReservationTerm());


            return "order_sheet";
        }

    //전송하기 페이지(modal) -> 저장
    @PostMapping("/order-complete")
    public String complete() {
        //주문내역 저장
        Reservation reservation;

        /*
        reservation = reservationService.saveReservation(reservationDto);
         */

        return "order_complete";
    }
}