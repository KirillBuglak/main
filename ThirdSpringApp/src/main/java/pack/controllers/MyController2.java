package pack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/two")
public class MyController2 {
    @GetMapping("/finish")
    public String finish(){
        return "two/finish";
    }
}
