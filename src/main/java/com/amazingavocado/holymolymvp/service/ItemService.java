package com.amazingavocado.holymolymvp.service;

import com.amazingavocado.holymolymvp.model.Filter;
import com.amazingavocado.holymolymvp.model.Item;
import com.amazingavocado.holymolymvp.model.User;
import com.amazingavocado.holymolymvp.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final EntityManager em;

    // 피드 정보
    @Transactional(readOnly = true)
    public List<Item> getItems(String regionCode, Filter filter) {

        String region = regionCode;
        String color = "";
        int startPrice = 0;
        int endPrice = 500000;

        if(filter.getFilterColor()!=null) {
            color = filter.getFilterColor();
            startPrice = filter.getFilterStartPrice();
            endPrice = filter.getFilterEndPrice();
        }

        region = '%' + region + '%';
        color = '%' + color + '%';

        Query query = em.createNativeQuery("SELECT * "
                            + "FROM shop AS s, item AS i "
                            + "WHERE s.shop_id = i.shop_id AND s.shop_address_code LIKE :region "
                            + "AND i.item_color LIKE :color AND i.item_start_price <= :end_price "
                            + "AND i.item_end_price >= :start_price ORDER BY RAND() "
                        , Item.class)
                            .setParameter("region", region)
                            .setParameter("color", color)
                            .setParameter("start_price", startPrice)
                            .setParameter("end_price", endPrice);

        List<Item> itemList = query.getResultList();

        return itemList;
    }

    // 개별 상품 정보 받아오기 (상품 상세 페이지)
    public Item getItem(Long itemId) {

        return itemRepository.findById(itemId).get();

    }


    public Long getShopId(Long itemId) {

        Optional<Item> item = itemRepository.findById(itemId);

        return item.get().getShop().getId();
    }
}
