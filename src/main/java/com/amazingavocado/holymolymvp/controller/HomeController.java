package com.amazingavocado.holymolymvp.controller;

import com.amazingavocado.holymolymvp.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    // 랜딩 페이지
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // 지역 선택 페이지
    @PostMapping("/region")
    public String region(@ModelAttribute("user") UserDto userDto, Model model) {
        model.addAttribute("user", userDto);
        return "region";
    }

}
