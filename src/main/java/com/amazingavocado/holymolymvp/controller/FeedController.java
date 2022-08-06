package com.amazingavocado.holymolymvp.controller;

import com.amazingavocado.holymolymvp.dto.UserDto;
import com.amazingavocado.holymolymvp.model.Filter;
import com.amazingavocado.holymolymvp.model.Item;
import com.amazingavocado.holymolymvp.model.User;
import com.amazingavocado.holymolymvp.service.FilterService;
import com.amazingavocado.holymolymvp.service.ItemService;
import com.amazingavocado.holymolymvp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FeedController {

    private final ItemService itemService;
    private final UserService userService;
    private final FilterService filterService;

    // GET 피드 페이지
    @GetMapping("/feed")
    public String getFeed() {
        return "redirect:/";
    }

    // POST 피드 페이지
    @PostMapping("/feed")
    public String feed(UserDto userDto, Filter filter, String code, Model model) {

        //유저 저장
        User user;
        if(userDto.getId() == null) {
            user = userService.saveUser(userDto);
            userDto.setId(user.getId());
        }
        else {
            user = userService.getUser(userDto.getId()).get();
        }

        //필터 저장
        if(filter != null) {
            filter = filterService.saveFilter(user, filter.getFilterColor(),
                    filter.getFilterStartPrice(), filter.getFilterEndPrice());
        }

        //아이템 리스트 출력
        List<Item> itemList = itemService.getItems(code, filter);
        model.addAttribute("user", user);
        model.addAttribute("code", code);
        model.addAttribute("filter", filter);
        model.addAttribute("itemList", itemList);
        return "feed";
    }

    // 꽃 상품 조회
    @GetMapping("/item/{userId}/{filterId}/{itemId}")
    public String Item(@PathVariable("userId") Long userId,
                       @PathVariable("filterId") Long filterId,
                       @PathVariable("itemId") Long itemId,
                       Model model) {
        Item item = itemService.getItem(itemId);
        Long shopId = itemService.getShopId(itemId);

        //아이템 출력
        model.addAttribute("userId", userId);
        model.addAttribute("filterId", filterId);
        model.addAttribute("item", item);
        model.addAttribute("shopId", shopId);
        model.addAttribute("itemId", itemId);


        System.out.println("첫번째");
        System.out.println(userId);
        System.out.println(filterId);
        System.out.println(shopId);
        System.out.println(itemId);

        return "item_detail";
    }
}