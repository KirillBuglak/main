package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/1")
public class HelloController {

    @GetMapping("/up")
    public String sayHello() {
        return "up";
    }

    @GetMapping("/like")
    public String like() {
    return "like";
}

    @GetMapping("calc")
    public String calc(@RequestParam("f")double f,
                       @RequestParam("s")double s,
                       @RequestParam("act")String act,
                       Model model) {
        double res = 0;

//        if (Objects.equals(act, "mu")) res+=f*s;
//        else if (Objects.equals(act, "ad")) res+=f+s;
//        else if (Objects.equals(act, "su")) res+=f-s;
//        else if (Objects.equals(act, "di")) res+=f/s;
//        else res=0.777;
        switch (act){
            case "mu": res+=f*s; break;
            case "ad": res+=f+s; break;
            case "su": res+=f-s; break;
            case "di": res+=f/s; break;
            default:res=0.777; break;
        }
        model.addAttribute("result","The result is "+res);
        return "calc";
    }

}