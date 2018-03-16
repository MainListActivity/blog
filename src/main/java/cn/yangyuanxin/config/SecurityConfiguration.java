package cn.yangyuanxin.config;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;


/**
 * Created by y
 * on 2018/3/10
 */
@EnableReactiveMethodSecurity
@EnableWebFluxSecurity
@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                .matchers(PathRequest.toStaticResources().atCommonLocations(),
                        ServerWebExchangeMatchers.pathMatchers("/images/**", "/assets/**", "/files/**")).permitAll()
                .pathMatchers("/**", "/bar")
                .authenticated().and()
                .formLogin();
        return http.build();
    }
//
//    @Bean
//    public ReactiveUserDetailsService userDetailsService() {
//        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//        UserDetails rob = User.withUsername("rob").password(passwordEncoder.encode("rob")).roles("USER").build();
//        UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("ADMIN").build();
//
//        return new MapReactiveUserDetailsService(rob, admin);
//    }


//    @Bean
//    public AclCache aclCache(PermissionGrantingStrategy grantingStrategy,
//                             AclAuthorizationStrategy aclAuthorizationStrategy) {
//        return new SpringCacheBasedAclCache(new ConcurrentMapCache("aclCache"), grantingStrategy, aclAuthorizationStrategy);
//    }
//
//    @Bean
//    public DefaultPermissionGrantingStrategy grantingStrategy() {
//        return new DefaultPermissionGrantingStrategy(new ConsoleAuditLogger());
//    }
//
//    @Bean
//    public AclAuthorizationStrategy aclAuthorizationStrategy() {
//        return new AclAuthorizationStrategyImpl(new SimpleGrantedAuthority[]{new SimpleGrantedAuthority("ADMIN"),
//                new SimpleGrantedAuthority("gaModifyAuditing"),
//                new SimpleGrantedAuthority("gaGeneralChanges")});
//    }
//
//    @Bean
//    public LookupStrategy basicLookupStrategy(DataSource dataSource,
//                                              AclCache aclCache,
//                                              AclAuthorizationStrategy aclAuthorizationStrategy,
//                                              PermissionGrantingStrategy grantingStrategy) {
//        return new BasicLookupStrategy(dataSource, aclCache, aclAuthorizationStrategy, grantingStrategy);
//    }
//
//    @Bean
//    public JdbcMutableAclService jdbcMutableAclService(DataSource dataSource,
//                                                       LookupStrategy lookupStrategy,
//                                                       AclCache aclCache) {
//        return new JdbcMutableAclService(dataSource, lookupStrategy, aclCache);
//    }
}
