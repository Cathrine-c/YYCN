package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.config.web.RequestResponseBodyMethodProcessorWrapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//定义SpringMVC的启动配置类
@Configuration
public class AppConfig implements WebMvcConfigurer, InitializingBean {

    @Autowired
    private ObjectMapper objectMapper;

    @Resource
    private RequestMappingHandlerAdapter adapter;

    //之前以@ControllerAdvice+实现ResponseBodyAdvice接口，完成统一处理返回数据包装：无法解决返回值为null需要包装
    //改用现在这种方式，可以解决返回null包装为自定义类型
    @Override
    public void afterPropertiesSet() throws Exception {

        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList(returnValueHandlers);
        for(int i=0; i<handlers.size(); i++){
            HandlerMethodReturnValueHandler handler = handlers.get(i);
            if(handler instanceof RequestResponseBodyMethodProcessor){
                handlers.set(i, new RequestResponseBodyMethodProcessorWrapper(handler));
            }
        }
        adapter.setReturnValueHandlers(handlers);

    }


    //配置Controller中请求映射方法路径匹配规则
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //设置路径前缀的规则，以第二个参数的返回值作为请求映射方法是否添加前缀
        configurer.addPathPrefix("api", c->true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    }

}

