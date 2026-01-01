package hello.login.web.login;

import hello.login.web.argumentresolver.LoginMemberArgumentResolver;
import hello.login.web.filter.LogFilter;
import hello.login.web.filter.LoginCheckFilter;
import hello.login.web.interceptor.LogInterceptor;
import hello.login.web.interceptor.LoginCheckInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import java.util.List;


@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginMemberArgumentResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**","/*.ico","/error");

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/members/add","/login",
                        "/logout","/css/**","/*.ico","/error");
    }



//    @Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean<Filter> FilterRegistrationBean = new FilterRegistrationBean<>();
        FilterRegistrationBean.setFilter(new LogFilter());
        FilterRegistrationBean.setOrder(1);
        FilterRegistrationBean.addUrlPatterns("/*");

        return FilterRegistrationBean;
    }

//    @Bean
    public FilterRegistrationBean loginCheckFilter(){
        FilterRegistrationBean<Filter> FilterRegistrationBean = new FilterRegistrationBean<>();
        FilterRegistrationBean.setFilter(new LoginCheckFilter());
        FilterRegistrationBean.setOrder(2);
        FilterRegistrationBean.addUrlPatterns("/*");

        return FilterRegistrationBean;
    }
}
