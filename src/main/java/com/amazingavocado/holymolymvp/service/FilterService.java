package com.amazingavocado.holymolymvp.service;

import com.amazingavocado.holymolymvp.model.Filter;
import com.amazingavocado.holymolymvp.model.User;
import com.amazingavocado.holymolymvp.repository.FilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilterService {

    private final FilterRepository filterRepository;

    public Filter saveFilter(User user, String color, String situation, int startPrice, int endPrice) {
        Filter filter = Filter.builder()
                .user(user)
                .filterColor(color)
                .filterStartPrice(startPrice)
                .filterEndPrice(endPrice)
                .filterSituation(situation).build();

        return filterRepository.save(filter);
    }
}