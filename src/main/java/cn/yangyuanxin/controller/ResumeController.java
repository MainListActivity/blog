package cn.yangyuanxin.controller;

import cn.yangyuanxin.domain.Resume;
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
@RequestMapping("/job")
public class ResumeController {
    private ResumeRepository resumeRepository;

    @Autowired
    public void setResumeRepository(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @RequestMapping()
    public String job(Model model) {
        Resume resume = resumeRepository.findAll().blockFirst();
        model.addAttribute("resume", resume);
        return "job";
    }

    @RequestMapping("/insert")
    public String insert(Model model) {
        Resume resume = new Resume();
        resume.setGender("w");
        resume.setName("y");
        model.addAttribute("resume", resumeRepository.save(resume));
        return "job";
    }

}
