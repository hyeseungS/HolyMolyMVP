package com.amazingavocado.holymolymvp.controller;

import com.amazingavocado.holymolymvp.dto.ReservationDto;
import com.amazingavocado.holymolymvp.dto.ReservationIdVo;
import com.amazingavocado.holymolymvp.dto.ReservationOrder2Vo;
import com.amazingavocado.holymolymvp.dto.ReservationOrder1Vo;
import com.amazingavocado.holymolymvp.model.Item;
import com.amazingavocado.holymolymvp.model.Reservation;
import com.amazingavocado.holymolymvp.repository.ReservationRepository;
import com.amazingavocado.holymolymvp.service.ItemService;
import com.amazingavocado.holymolymvp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ItemService itemService;
    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository;

    //예약 시작 페이지1
    @PostMapping("/order1")
    public String createOrder(ReservationIdVo reservationIdVo, Model model) {

        // id 정보 넘기기
        model.addAttribute("userId", reservationIdVo.getUserId());
        model.addAttribute("filterId", reservationIdVo.getFilterId());
        model.addAttribute("shopId", reservationIdVo.getShopId());
        model.addAttribute("itemId", reservationIdVo.getItemId());

        //가격 정보 넘기기
        Item item = itemService.getItem(reservationIdVo.getItemId());
        model.addAttribute("item", item);

        //가격 정보
        int startPrice = item.getItemStartPrice();
        int endPrice = item.getItemEndPrice();
        model.addAttribute("priceList", makePriceList(startPrice, endPrice));

        model.addAttribute("ItemStartPrice", startPrice);
        model.addAttribute("ItemEndPrice", endPrice);


        System.out.println("두번째");
        System.out.println(reservationIdVo.getUserId());
        System.out.println(reservationIdVo.getFilterId());
        System.out.println(reservationIdVo.getShopId());
        System.out.println(reservationIdVo.getItemId());

        return "order_info";
    }


    //예약 시작 페이지2
    @PostMapping("/order2")
    public String createOrder2(ReservationOrder1Vo reservationOrder1Vo, String reservationPrice, Model model) {

        // id 정보 넘기기
        model.addAttribute("userId", reservationOrder1Vo.getUserId());
        model.addAttribute("filterId", reservationOrder1Vo.getFilterId());
        model.addAttribute("shopId", reservationOrder1Vo.getShopId());
        model.addAttribute("itemId", reservationOrder1Vo.getItemId());

        //order1 정보 넘기기
        model.addAttribute("reservationPrice", reservationPrice);
        model.addAttribute("reservationWay", reservationOrder1Vo.getReservationWay());
        model.addAttribute("reservationDeliveryAddress", reservationOrder1Vo.getReservationDeliveryAddress());
        model.addAttribute("reservationPickupDate", reservationOrder1Vo.getReservationPickupDate());
        model.addAttribute("reservationPickupTime", reservationOrder1Vo.getReservationPickupTime());


        System.out.println("세번째");
        System.out.println(reservationOrder1Vo.getUserId());
        System.out.println(reservationOrder1Vo.getFilterId());
        System.out.println(reservationOrder1Vo.getShopId());
        System.out.println(reservationOrder1Vo.getItemId());
        System.out.println(reservationPrice);
        System.out.println(reservationOrder1Vo.getReservationWay());
        System.out.println(reservationOrder1Vo.getReservationDeliveryAddress());
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
        model.addAttribute("reservationWay", reservationOrder2Vo.getReservationWay());
        model.addAttribute("reservationDeliveryAddress", reservationOrder2Vo.getReservationDeliveryAddress());
        model.addAttribute("reservationPickupDate", reservationOrder2Vo.getReservationPickupDate());
        model.addAttribute("reservationPickupTime", reservationOrder2Vo.getReservationPickupTime());

        //coupon adding 앞에 붙이기
        //String couponNadding = "[쿠폰번호: " + coupon + " ] / " + reservationOrder2Vo.getReservationAdding();

        //order2 정보 넘기기
        model.addAttribute("reservationAdding", reservationOrder2Vo.getReservationAdding());
        model.addAttribute("reservationSituation", reservationOrder2Vo.getReservationSituation());
        model.addAttribute("reservationMsgCard", reservationOrder2Vo.getReservationMsgCard());
        model.addAttribute("reservationCoupon", reservationOrder2Vo.getReservationCoupon());

        System.out.println("네번째");
        System.out.println(reservationOrder2Vo.getUserId());
        System.out.println(reservationOrder2Vo.getFilterId());
        System.out.println(reservationOrder2Vo.getShopId());
        System.out.println(reservationOrder2Vo.getItemId());

        System.out.println(reservationOrder2Vo.getReservationPrice());
        System.out.println(reservationOrder2Vo.getReservationWay());
        System.out.println(reservationOrder2Vo.getReservationDeliveryAddress());
        System.out.println(reservationOrder2Vo.getReservationPickupDate());
        System.out.println(reservationOrder2Vo.getReservationPickupTime());

        System.out.println(reservationOrder2Vo.getReservationAdding());
        System.out.println(reservationOrder2Vo.getReservationSituation());
        System.out.println(reservationOrder2Vo.getReservationMsgCard());
        System.out.println(reservationOrder2Vo.getReservationCoupon());

        return "orderer_info";
    }

    @PostMapping("/order-sheet")
    public String sendOrder(ReservationDto reservationDto, Model model) {

        // id 정보에서 추가
        Item item = itemService.getItem(reservationDto.getItemId());

        model.addAttribute("item", item);

        //가격 정보
        int startPrice = item.getItemStartPrice();
        int endPrice = item.getItemEndPrice();

        model.addAttribute("ItemStartPrice", startPrice);
        model.addAttribute("ItemEndPrice", endPrice);

        // id 정보 넘기기
        model.addAttribute("userId", reservationDto.getUserId());
        model.addAttribute("filterId", reservationDto.getFilterId());
        model.addAttribute("shopId", reservationDto.getShopId());
        model.addAttribute("itemId", reservationDto.getItemId());

        //order1 정보 넘기기
        model.addAttribute("reservationPrice", reservationDto.getReservationPrice());
        model.addAttribute("reservationWay", reservationDto.getReservationWay());
        model.addAttribute("reservationDeliveryAddress", reservationDto.getReservationDeliveryAddress());
        model.addAttribute("reservationPickupDate", reservationDto.getReservationPickupDate());
        model.addAttribute("reservationPickupTime", reservationDto.getReservationPickupTime());

        //order2 정보 넘기기
        model.addAttribute("reservationAdding", reservationDto.getReservationAdding());
        model.addAttribute("reservationSituation", reservationDto.getReservationSituation());
        model.addAttribute("reservationMsgCard", reservationDto.getReservationMsgCard());
        model.addAttribute("reservationCoupon", reservationDto.getReservationCoupon());

        //orderer 정보 넘기기
        model.addAttribute("reservationOrdererName", reservationDto.getReservationOrdererName());
        model.addAttribute("reservationOrdererPhone", reservationDto.getReservationOrdererPhone());
        model.addAttribute("reservationTerm", reservationDto.getReservationTerm());

        System.out.println("다섯번째");
        System.out.println(reservationDto.getReservationWay());
        System.out.println(reservationDto.getReservationDeliveryAddress());

        System.out.println(reservationDto.getReservationAdding());
        System.out.println(reservationDto.getReservationSituation());
        System.out.println(reservationDto.getReservationMsgCard());
        System.out.println(reservationDto.getReservationCoupon());

        System.out.println(reservationDto.getReservationOrdererName());
        System.out.println(reservationDto.getReservationOrdererPhone());
        System.out.println(reservationDto.getReservationTerm());

        return "order_sheet";
    }

    //주문내역서 페이지(modal) -> 저장
    @PostMapping("/order-complete")
    public String complete(ReservationDto reservationDto) {

        //위에랑 정보를 그대로 받아서 효율적으로 넘기는 방법(위에서 한번 저장시켜논다던지?) 생각해봐야

        Reservation reservation;
        reservation = reservationService.saveReservation(reservationDto);
        System.out.println(reservation.toString());

        /*
        //1. 주문내역 저장 dto->entity
        Reservation reservation = reservationDto.toEntity();
        System.out.println(reservation.toString());

        //2. Repository에게 Entity를 DB로 저장하게 함
        Reservation savedReservation = reservationRepository.save(reservation);
        System.out.println(savedReservation.toString());
        */

        return "order_complete";
    }

    public List<Integer> makePriceList(Integer start_price, Integer end_price) {

        ArrayList<Integer> priceList = new ArrayList<>();
        int gap = end_price - start_price;
        priceList.add(start_price);

        if (gap <= 15000) {
            //리스트에 오천원 단위로 가격 넣기
            int price = start_price + 5000;
            while (price < end_price) {
                priceList.add(price);
                price += 5000;
            }
            priceList.add(end_price);
        } else {
            //리스트에 start_price, 중간값, end_price 넣기
            priceList.add((start_price + end_price) / 2);
            priceList.add(end_price);
        }

        return priceList;
    }
}