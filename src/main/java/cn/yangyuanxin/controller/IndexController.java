package cn.yangyuanxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by y
 * on 2018/3/9
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index1() {
        return "index";
    }
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/left-sidebar")
    public String leftSidebar() {
        return "left-sidebar";
    }

    @RequestMapping("/no-sidebar")
    public String noSidebar() {
        return "no-sidebar";
    }

    @RequestMapping("/right-sidebar")
    public String rightSidebar() {
        return "right-sidebar";
    }


}
