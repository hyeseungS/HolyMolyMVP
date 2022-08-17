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

    // 첫번째 소개 페이지
//    @GetMapping("/")
//    public String main1() { return "index"; }

    // 두번째 소개 페이지
//    @GetMapping("/page2")
//    public String main2() { return "page2"; }

    // 세번째 소개 페이지
//    @GetMapping("/page3")
//    public String main3() { return "page3"; }

    // 네번째 소개 페이지
//    @GetMapping("/page4")
//    public String main4() { return "page4"; }

    // 다섯번째 소개 페이지
//    @GetMapping("/page5")
//    public String main5() { return "page5"; }

    // 랜딩 페이지
//    @GetMapping("/gender")
//    public String home() { return "gender"; }

    // GET 지역 선택 페이지
//    @GetMapping("/region")
//    public String getRegion() {
//        return "redirect:/";
//    }

    // POST 지역 선택 페이지
//    @PostMapping("/region")
//    public String region(int age, int gender, Model model) {
//        model.addAttribute("age", age);
//        model.addAttribute("gender", gender);
//        return "region";
//    }

    // GET 지역 선택 페이지
    @GetMapping("/")
    public String getRegion() {
        return "region";
    }

}