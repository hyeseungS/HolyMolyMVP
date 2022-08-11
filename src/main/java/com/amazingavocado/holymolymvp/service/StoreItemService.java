package com.amazingavocado.holymolymvp.service;

import com.amazingavocado.holymolymvp.model.*;
import com.amazingavocado.holymolymvp.repository.ItemRepository;
import com.amazingavocado.holymolymvp.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreItemService {

    private final ItemRepository itemRepository;
    private final ShopRepository shopRepository;

    // 가게 정보
    @Transactional(readOnly = true)
    public List<Item> getItems(Long shopId) {

        Optional<Shop> shop = shopRepository.findById(shopId);
        List<Item> itemList = itemRepository.findByShop(shop.get());

        return itemList;
    }

    // 가게 정보 받아오기 (가게 페이지)
    public Shop getShop(Long shopId) {
        return shopRepository.findById(shopId).get();
    }

}
