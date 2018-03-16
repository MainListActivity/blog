package cn.yangyuanxin.controller;

import cn.yangyuanxin.domain.Index;
import cn.yangyuanxin.domain.UserDO;
import cn.yangyuanxin.repository.IndexRepository;
import cn.yangyuanxin.service.UserService;
import cn.yangyuanxin.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/**
 * Created by y
 * on 2018/3/9
 */
@Controller
public class IndexController {
    private IndexRepository indexRepository;


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setIndexRepository(IndexRepository indexRepository) {
        this.indexRepository = indexRepository;
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @ResponseBody
    @GetMapping("/indexJson")
    public Flux<Index> indexFlux() {
        return indexRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/index1")
    public UserVo indexMono(@RequestParam(value = "username") String userName) {
        return userService.getUserRole(userName);
    }

    @ResponseBody
    @PostMapping("/indexJson")
    public int insertIndex(@RequestParam Long id, @RequestParam String password) {
        UserDO userDO = userService.get(id);
        userDO.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password));
        return userService.update(userDO);
    }


    @RequestMapping("/index")
    public String index(Model model) {
        return "/index";
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
