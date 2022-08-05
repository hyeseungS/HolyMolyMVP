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

    /* private final StoreItemService storeItemService;
    private final UserService userService;

    // GET 피드 페이지
    @GetMapping("/store_detail")
    public String getFeed() {
        return "redirect:/";
    }

    // POST 피드 페이지
    @PostMapping("/store_detail")
    public String store_detail(UserDto userDto, Model model) {
        User user;
        if(userDto.getId() == null) {
            user = userService.saveUser(userDto);
            userDto.setId(user.getId());
        }
        else {
            user = userService.getUser(userDto.getId()).get();
        }
        List<Item> itemList = StoreItemService.getItems(user);
        model.addAttribute("user", user);
        model.addAttribute("itemList", itemList);
        return "store_detail";
    }

    // 꽃 상품 정보
    @GetMapping("/item/{itemId}")
    public String Item(User user, @PathVariable("itemId") Long itemId, Model model) {
        Item item = StoreItemService.getItem(itemId);

        model.addAttribute("user", user);
        model.addAttribute("item", item);

        return "item_detail";
    }*/
}
