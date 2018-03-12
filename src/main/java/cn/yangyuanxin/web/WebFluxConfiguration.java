package cn.yangyuanxin.web;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.List;

/**
 * Created by y
 * on 2018/3/10
 */
//@Configuration
public class WebFluxConfiguration {
    private ServerProperties serverProperties;
    private ApplicationContext applicationContext;
    private ResourceProperties resourceProperties;
    private ErrorProperties errorProperties;
    private List<ViewResolver> viewResolvers;
    private ServerCodecConfigurer serverCodecConfigurer;

    public WebFluxConfiguration(ServerProperties serverProperties,
                                ApplicationContext applicationContext,
                                ResourceProperties resourceProperties,
                                ErrorProperties errorProperties,
                                List<ViewResolver> viewResolvers,
                                ServerCodecConfigurer serverCodecConfigurer) {
        this.serverProperties = serverProperties;
        this.applicationContext = applicationContext;
        this.resourceProperties = resourceProperties;
        this.errorProperties = errorProperties;
        this.viewResolvers = viewResolvers;
        this.serverCodecConfigurer = serverCodecConfigurer;
    }

    @Bean
    @Primary
    @Order(-1)
    public DefaultErrorWebExceptionHandler errorWebExceptionHandler(ErrorAttributes errorAttributes, MessageSource messageSource) {
        return new DefaultErrorWebExceptionHandler(errorAttributes, resourceProperties, errorProperties, applicationContext);
    }
}
