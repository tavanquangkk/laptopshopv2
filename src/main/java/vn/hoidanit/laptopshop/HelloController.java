package vn.hoidanit.laptopshop;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloController {
    @GetMapping("/hello")
    public String index() {
        return "Hello World from spring with quangDev hahaha";
    }
    @GetMapping("/user")
    public String userPage() {
        return "only user can access this page ";
    }
    @GetMapping("/admin")
    public String adminPage() {
        return "only admin can access this page ";
    }
    
    
}
