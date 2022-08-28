package com.seamoon.pjt.springthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/text")
public class TextSampleController {

    @GetMapping("/text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello Thymeleaf");
        return "text/text-basic";
    }

    @GetMapping("/text-escape")
    public String textEscape(Model model) {
        model.addAttribute("data", "Hello <b>Thymeleaf</b>");
        return "text/text-escape";
    }

    @GetMapping("/text-unesacped")
    public String textUnescape(Model model) {
        model.addAttribute("data", "Hello <b>Thymeleaf!</b>");
        return "text/text-unescape";
    }
}
