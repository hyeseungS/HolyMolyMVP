package com.amazingavocado.holymolymvp.service;

import com.amazingavocado.holymolymvp.model.Filter;
import com.amazingavocado.holymolymvp.model.Item;
import com.amazingavocado.holymolymvp.model.Shop;
import com.amazingavocado.holymolymvp.model.User;
import com.amazingavocado.holymolymvp.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final EntityManager em;

    // 피드 정보
    @Transactional(readOnly = true)
    public List<Item> getItems(User user, Filter filter) {

        String region = user.getRegion();
        String color = filter.getFilterColor();
        int startPrice = filter.getFilterStartPrice();
        int endPrice = filter.getFilterEndPrice();
        String situation = filter.getFilterSituation();

        Query query = em.createNativeQuery("SELECT * "
                            + "FROM shop AS s, item AS i "
                            + "AND s.shop_id = i.shop_id AND s.shop_address CONTAINS :region "
                            + "AND i.item_color CONTAINS :color AND i.item_start_price >= :start_price "
                            + "AND i.item_end_price <= :end_price AND i.item_category CONTAINS :situation"
                        , Shop.class)
                            .setParameter("region", region)
                            .setParameter("color", color)
                            .setParameter("start_price", startPrice)
                            .setParameter("end_price", endPrice)
                            .setParameter("situation", situation);


        List<Item> itemList = query.getResultList();

        return itemList;
    }

    // 상품 정보
    public Item getItem(Long itemId) {

        return itemRepository.findById(itemId).get();

    }
}
