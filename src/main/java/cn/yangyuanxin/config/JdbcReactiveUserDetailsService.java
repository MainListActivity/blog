package cn.yangyuanxin.config;

import cn.yangyuanxin.service.UserService;
import cn.yangyuanxin.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


/**
 * 版权所有：   y.
 * 创建日期：   18-3-16.
 * 重要说明：
 * 修订历史：
 */
@Service
@Primary
public class JdbcReactiveUserDetailsService implements ReactiveUserDetailsService {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        UserVo userVo = userService.getUserRole(username);
        UserDetails userDetails = User.withUsername(username)
                .password(userVo.getPassword())
                .roles(userVo.getRoles().toArray(new String[]{}))
                .authorities(userVo.getMenus().toArray(new String[]{}))
                .build();
        return Mono.just(userDetails);
    }

}
