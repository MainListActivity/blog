package cn.yangyuanxin.repository;

import cn.yangyuanxin.model.Resume;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Created by y
 * on 2018/3/11
 */
public interface ResumeRepository extends ReactiveCrudRepository<Resume, Long> {
}
