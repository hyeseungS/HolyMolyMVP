package com.amazingavocado.holymolymvp.service;

import com.amazingavocado.holymolymvp.model.Filter;
import com.amazingavocado.holymolymvp.model.Item;
import com.amazingavocado.holymolymvp.model.Shop;
import com.amazingavocado.holymolymvp.model.User;
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

    // 피드 정보
    @Transactional(readOnly = true)
    public List<Item> getItems(Long shopId) {

        Optional<Shop> shop = shopRepository.findById(shopId);
        List<Item> itemList = itemRepository.findByShop(shop.get());

        return itemList;
    }

    // 개별 상품 정보 받아오기 (상품 상세 페이지)
    public Item getItem(Long itemId) {

        return itemRepository.findById(itemId).get();

    }
}
