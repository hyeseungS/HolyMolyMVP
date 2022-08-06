package com.amazingavocado.holymolymvp.service;

import com.amazingavocado.holymolymvp.dto.ReservationDto;
import com.amazingavocado.holymolymvp.dto.ReservationIdVo;
import com.amazingavocado.holymolymvp.dto.ReservationOrderVo;
import com.amazingavocado.holymolymvp.model.Filter;
import com.amazingavocado.holymolymvp.model.Item;
import com.amazingavocado.holymolymvp.model.User;
import com.amazingavocado.holymolymvp.model.Reservation;
import com.amazingavocado.holymolymvp.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;


    public Reservation saveReservation(ReservationDto reservationDto) {

        Reservation reservation = Reservation.builder()
                .userId(reservationDto.getUserId())
                .filterId(reservationDto.getFilterId())
                .shopId(reservationDto.getShopId())
                .itemId(reservationDto.getItemId())
                .reservationPrice(reservationDto.getReservationPrice())
                .reservationCreateDate(reservationDto.getReservationPickupDate())
                .reservationPickupTime(reservationDto.getReservationPickupTime())
                .reservationAdding(reservationDto.getReservationAdding())
                .reservationSituation(reservationDto.getReservationSituation())
                .reservationOrdererName(reservationDto.getReservationOrdererName())
                .reservationOrdererPhone(reservationDto.getReservationOrdererPhone())
                .build();

        return reservationRepository.save(reservation);
    }
}
