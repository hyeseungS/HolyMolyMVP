package com.amazingavocado.holymolymvp.controller;

import com.amazingavocado.holymolymvp.dto.UserDto;
import com.amazingavocado.holymolymvp.model.Filter;
import com.amazingavocado.holymolymvp.model.Item;
import com.amazingavocado.holymolymvp.model.User;
import com.amazingavocado.holymolymvp.repository.ItemRepository;
import com.amazingavocado.holymolymvp.service.FilterService;
import com.amazingavocado.holymolymvp.service.ItemService;
import com.amazingavocado.holymolymvp.service.UserService;
import lombok.RequiredArgsConstructor;
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
    private final ItemRepository itemRepository;

    // 피드 페이지
    @GetMapping("/feed")
    public String feed(Model model) {
        List<Item> itemList = itemRepository.findAll();
        model.addAttribute("itemList", itemList);
        return "feed";
    }
//    public String feed(@ModelAttribute("userDto") UserDto userDto, @ModelAttribute("user") User user,
//                       @ModelAttribute("filter") Filter filter, Model model) {
//
//        if(userDto != null) {
//            user = userService.saveUser(userDto);
//        }
//
//        List<Item> itemList = itemService.getItems(user, filter);
//        model.addAttribute("user", user);
//        model.addAttribute("item", itemList);
//
//        return "feed";
//    }

    // 필터링 내역 저장
    @PostMapping("/filter")
    public String saveFilter(@ModelAttribute("user") User user, @RequestParam(name = "color") String color,
                             @RequestParam("situation") String situation,
                             @RequestParam("startPrice") int startPrice, @RequestParam("endPrice") int endPrice,
                             Model model) {

        Filter filter = filterService.saveFilter(user, color, situation, startPrice, endPrice);
        List<Item> itemList = itemService.getItems(user, filter);
        model.addAttribute("user", user);
        model.addAttribute("filter", filter);
        model.addAttribute("item", itemList);

        return "feed";
    }

    // 꽃 상품 정보
    @GetMapping("/item/{itemId}")
    public String Item(@ModelAttribute("user") User user, @ModelAttribute("filterId") Long filterId, @PathVariable("itemId") Long itemId, Model model) {
        Item item = itemService.getItem(itemId);

        model.addAttribute("user", user);
        model.addAttribute("filterId", filterId);
        model.addAttribute("item", item);

        return "flower";
    }
}
