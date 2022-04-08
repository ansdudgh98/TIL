package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestRestController {
    @PostMapping("/test")
    public void test(){
        log.info("post test controller");
    }
    @GetMapping("/test")
    public void gettest(){
        log.info("get test controller");
    }


}
