package com.amazingavocado.holymolymvp.controller;

import com.amazingavocado.holymolymvp.model.*;
import com.amazingavocado.holymolymvp.service.ItemService;
import com.amazingavocado.holymolymvp.service.StoreItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StoreDetailController {

    private final StoreItemService storeItemService;
    private final ItemService itemService;

    // GET 가게 페이지
    @GetMapping("/item/{userId}/{filterId}/{itemId}/{shopId}")
    public String storeDetail(@PathVariable("userId") Long userId, @PathVariable("filterId") Long filterId, @PathVariable("itemId") Long itemId, @PathVariable("shopId") Long shopId, Model model) {

        List<Item> itemList = storeItemService.getItems(shopId);
        Item item = itemService.getItem(itemId);
        Shop shop = storeItemService.getShop(shopId);
        model.addAttribute("userId", userId);
        model.addAttribute("filterId", filterId);
        model.addAttribute("item", item);
        model.addAttribute("shop", shop);
        model.addAttribute("itemId", itemId);
        model.addAttribute("itemList", itemList);
        return "store_detail";
    }

    // GET 가게 페이지
    @GetMapping("/shop/{userId}/{filterId}/{shopId}")
    public String storeDetailByMap(@PathVariable("userId") Long userId, @PathVariable("filterId") Long filterId, @PathVariable("shopId") Long shopId, Model model) {

        List<Item> itemList = storeItemService.getItems(shopId);
        Shop shop = storeItemService.getShop(shopId);
        model.addAttribute("userId", userId);
        model.addAttribute("filterId", filterId);
        model.addAttribute("itemList", itemList);
        model.addAttribute("shop", shop);
        return "store_detail";
    }

}
