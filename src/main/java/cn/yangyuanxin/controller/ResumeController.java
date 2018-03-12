package cn.yangyuanxin.controller;

import cn.yangyuanxin.model.Resume;
import cn.yangyuanxin.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by y
 * on 2018/3/11
 */
@Controller
public class ResumeController {
    private ResumeRepository resumeRepository;

    @Autowired
    public void setResumeRepository(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @RequestMapping("/job")
    public String job(Model model) {
        Resume resume = resumeRepository.findAll().blockFirst();
        model.addAttribute("resume", resume);
        return "job";
    }

}
