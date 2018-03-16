package cn.yangyuanxin.config;

import cn.yangyuanxin.domain.UserDO;
import cn.yangyuanxin.service.UserService;
import cn.yangyuanxin.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private static final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        UserVo userVo = userService.getUserRole(username);
        UserDetails userDetails = User.withUsername(username)
                .password(userVo.getPassword())
                .passwordEncoder(passwordEncoder::encode)
                .roles(userVo.getRoles().toArray(new String[]{}))
                .build();
        return Mono.just(userDetails);
    }

}
