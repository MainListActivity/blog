package cn.yangyuanxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 版权所有：   y.
 * 创建日期：   18-3-19.
 * 重要说明：
 * 修订历史：
 */
@Controller
public class EditController {
    @GetMapping("/edit")
    public String edit() {
        return "blog_editor";
    }
}
