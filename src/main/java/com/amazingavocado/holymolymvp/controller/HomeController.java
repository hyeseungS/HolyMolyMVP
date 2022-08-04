package com.amazingavocado.holymolymvp.controller;

import com.amazingavocado.holymolymvp.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    // 랜딩 페이지
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // GET 지역 선택 페이지
    @GetMapping("/region")
    public String getRegion() {
        return "redirect:/";
    }

    // POST 지역 선택 페이지
    @PostMapping("/region")
    public String region(UserDto userDto, Model model) {
        model.addAttribute("age", userDto.getAge());
        model.addAttribute("gender", userDto.getGender());
        return "region";
    }

}
