package hello.proxy.cglib;

import hello.proxy.cglib.code.TimeMethodInterceptor;
import hello.proxy.common.service.ConCreateService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {

    @Test
    void cglib(){
        ConCreateService target = new ConCreateService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConCreateService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));

        ConCreateService proxy = (ConCreateService) enhancer.create();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.call();
    }
}
