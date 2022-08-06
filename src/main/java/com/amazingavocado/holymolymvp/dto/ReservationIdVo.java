package com.amazingavocado.holymolymvp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class ReservationIdVo {
    // 예약시 id들 저장, 조회 - ReservationController.createOrder()
    private Long userId;

    private Long filterId;

    private Long shopId;

    private Long itemId;
}
