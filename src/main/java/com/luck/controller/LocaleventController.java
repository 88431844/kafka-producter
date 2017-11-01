package com.luck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author miracle
 * @Date 2017/10/31 0031 14:54
 */
@Controller
@RequestMapping("/localevent")

public class LocaleventController {

    @RequestMapping("/speed")
    public void sendSpeed(){

    }

    @RequestMapping("/point")
    public void sendPoint(){

    }
    @RequestMapping("/status")
    public void sendStatus(){

    }
}
