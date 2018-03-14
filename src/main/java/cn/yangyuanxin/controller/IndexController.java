package cn.yangyuanxin.controller;

import cn.yangyuanxin.domain.Index;
import cn.yangyuanxin.repository.IndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String index1(Model model) {
        return "index";
    }

    @ResponseBody
    @GetMapping("/indexJson")
    public Flux<Index> indexMono() {
        return indexRepository.findAll();
    }

    @ResponseBody
    @PostMapping("/indexJson")
    public Mono<Index> insertIndex(@RequestBody Index index) {
        return indexRepository.save(index);
    }

    @RequestMapping("/index")
    public String index(Model model) {
        return index1(model);
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
