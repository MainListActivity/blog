package cn.yangyuanxin.repository;

import cn.yangyuanxin.domain.Index;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * 版权所有：   y.
 * 创建日期：   18-3-14.
 * 重要说明：
 * 修订历史：
 */
public interface IndexRepository extends ReactiveCrudRepository<Index, String> {
    Mono<Index> findByUid(Long uid);
}
