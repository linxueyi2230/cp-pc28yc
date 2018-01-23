package com.dandanyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/open")
public class JsonControl {

    @ResponseBody
    @RequestMapping("/PcJnd")
    public String getPcJndNewInfo() {


        return "";
    }
}
