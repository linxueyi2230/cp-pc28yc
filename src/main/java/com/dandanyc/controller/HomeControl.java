package com.dandanyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by prothezou on 2016/12/24.
 */
@RequestMapping("/")
@Controller
public class HomeControl {

    @RequestMapping("/")
    public String getHome() {
        return "page/index";
    }
}
