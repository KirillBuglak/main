package pack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("url")
public class MyController {

    @GetMapping("oops")
    public String oops() {
        return "oops";
    }

    @GetMapping("hello_world")
    public String hello(@RequestParam(value = "param", required = false) String param,
                        Model model) {
        model.addAttribute("message","Param = "+param);
        return "hello_world";
    }
    @GetMapping("sum")
    public String summer(@RequestParam(value = "first") int x,
                         @RequestParam(value = "second") int y, Model model){
        model.addAttribute("summ","Summ = "+(x+y));
        return "summer";
    }
}