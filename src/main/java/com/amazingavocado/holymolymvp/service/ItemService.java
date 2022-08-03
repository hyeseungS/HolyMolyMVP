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

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final EntityManager em;

    // 피드 정보
    @Transactional(readOnly = true)
    public List<Item> getItems(User user, Filter filter) {

        String region = user.getRegion();
        String color = "";
        int startPrice = 0;
        int endPrice = 100000;
        String situation = "";

        if(filter.getFilterColor()!=null) {
            color = filter.getFilterColor();
            startPrice = filter.getFilterStartPrice();
            endPrice = filter.getFilterEndPrice();
            situation = filter.getFilterSituation();
        }

        if(region.equals("전체")) region = "";

        region = '%' + region + '%';
        color = '%' + color + '%';
        situation = '%' + situation + '%';

        Query query = em.createNativeQuery("SELECT * "
                            + "FROM shop AS s, item AS i "
                            + "WHERE s.shop_id = i.shop_id AND s.shop_address LIKE :region "
                            + "AND i.item_color LIKE :color AND i.item_start_price <= :end_price "
                            + "AND i.item_end_price >= :start_price AND i.item_category LIKE :situation "
                        , Item.class)
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