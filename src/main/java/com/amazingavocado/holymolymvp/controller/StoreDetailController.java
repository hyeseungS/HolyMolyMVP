package com.amazingavocado.holymolymvp.controller;

import com.amazingavocado.holymolymvp.dto.UserDto;
import com.amazingavocado.holymolymvp.model.Item;
import com.amazingavocado.holymolymvp.model.User;
import com.amazingavocado.holymolymvp.service.StoreItemService;
import com.amazingavocado.holymolymvp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StoreDetailController {

    private final StoreItemService storeItemService;
    private final UserService userService;

    // GET 가게 페이지
    @GetMapping("/store/{userId}/{shopId}")
    public String storeDetail(@PathVariable("userId") Long userId, @PathVariable("shopId") Long shopId, Model model) {
        User user = userService.getUser(userId).get();

        List<Item> itemList = storeItemService.getItems(shopId);
        model.addAttribute("user", user);
        model.addAttribute("itemList", itemList);
        return "store_detail";
    }

}
