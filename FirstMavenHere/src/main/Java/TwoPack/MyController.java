package TwoPack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/doit")
    public String doIT(){
        return "doit";
    }
}
