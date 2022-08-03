package com.amazingavocado.holymolymvp.controller;

import com.amazingavocado.holymolymvp.dto.UserDto;
import com.amazingavocado.holymolymvp.model.Filter;
import com.amazingavocado.holymolymvp.model.Item;
import com.amazingavocado.holymolymvp.model.User;
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

    // 피드 페이지
    @PostMapping("/feed")
    public String feed(UserDto userDto, Filter filter, Model model) {
        User user = userService.saveUser(userDto);
        userDto.setId(user.getId());
        if(filter != null) {
            filter = filterService.saveFilter(user, filter.getFilterColor(),
                    filter.getFilterStartPrice(), filter.getFilterEndPrice());
        }
        List<Item> itemList = itemService.getItems(user, filter);
        model.addAttribute("user", user);
        model.addAttribute("filter", filter);
        model.addAttribute("itemList", itemList);
        return "feed";
    }

    // 꽃 상품 정보
    @GetMapping("/item/{itemId}")
    public String Item(User user, Filter filter, @PathVariable("itemId") Long itemId, Model model) {
        Item item = itemService.getItem(itemId);

        model.addAttribute("user", user);
        model.addAttribute("filter", filter);
        model.addAttribute("item", item);

        return "flower";
    }
}
