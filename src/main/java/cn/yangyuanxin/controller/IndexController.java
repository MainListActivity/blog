package cn.yangyuanxin.controller;

import cn.yangyuanxin.domain.Index;
import cn.yangyuanxin.repository.IndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by y
 * on 2018/3/9
 */
@Controller
public class IndexController {
    private IndexRepository indexRepository;

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
    public Mono<Index> indexMono() {
        return indexRepository.findByUid(1L);
    }

    @ResponseBody
    @PostMapping("/indexJson")
    public Mono<Index> insertIndex(@RequestBody Index index) {
        return indexRepository.save(index);
    }


    @RequestMapping("/index")
    public String index(Model model) {
        return "/index";
    }

    @PreAuthorize("hasPermission(#rememberMe,'IS_AUTHENTICATED_FULLY')")
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
