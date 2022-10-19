package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String user(){
        return "get users";
    }
    @PostMapping
    public String addUser(){
        return "post user";
    }
    @GetMapping("{userid}")
    public String findUser(@PathVariable String userId){
        return "find userId = " +userId;
    }
    @PatchMapping("{userid}")
    public String updateUser(@PathVariable String userId){
        return "update userId = " +userId;
    }
    @DeleteMapping("{userid}")
    public String deleteUser(@PathVariable String userId){
        return "delete userId = " +userId;
    }
}
