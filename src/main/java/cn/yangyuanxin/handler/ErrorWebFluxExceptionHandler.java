package cn.yangyuanxin.handler;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.web.reactive.function.server.RenderingResponse;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.WebSession;

/**
 * Created by y
 * on 2018/3/10
 */
public class ErrorWebFluxExceptionHandler extends DefaultErrorWebExceptionHandler {
    ErrorAttributes errorAttributes;
    ResourceProperties resourceProperties;
    ErrorProperties errorProperties;
    ApplicationContext applicationContext;
    private MessageSource messageSource;

    public ErrorWebFluxExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ErrorProperties errorProperties, ApplicationContext applicationContext, ErrorAttributes errorAttributes1, ResourceProperties resourceProperties1, ErrorProperties errorProperties1, ApplicationContext applicationContext1, MessageSource messageSource) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
        this.errorAttributes = errorAttributes1;
        this.resourceProperties = resourceProperties1;
        this.errorProperties = errorProperties1;
        this.applicationContext = applicationContext1;
        this.messageSource = messageSource;
    }

    @Override
    public RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
//        RouterFunction<ServerResponse> routerFunction =
//                super.getRoutingFunction(errorAttributes).filter((request, next) -> {
//                    next.handle(request).flatMap(serverResponse -> {
//                        serverResponse
//                    })
//                });
        return super.getRoutingFunction(errorAttributes);

    }
}