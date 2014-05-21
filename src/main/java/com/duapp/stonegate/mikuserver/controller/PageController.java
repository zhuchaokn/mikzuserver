package com.duapp.stonegate.mikuserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chao.zhu
 * 14-4-28
 * 上午11:01
 */
@Controller
public class PageController {
    @RequestMapping(value = {"","/"})
    public String index(){
        return "index";
    }
}
