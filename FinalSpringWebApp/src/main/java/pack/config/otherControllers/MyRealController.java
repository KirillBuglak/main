package pack.config.otherControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyRealController {

    @GetMapping("smth")
    public String smth(){
        return "folder/smth";
    }

    @GetMapping("anth")
    public String amth(HttpServletRequest request){
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        System.out.println(first+" "+second);

        return "folder/anth";
    }

    @GetMapping("finish")
    public String finish(){
        return "folder/finish";
    }

    @GetMapping("param")
    public String param(@RequestParam("rts") String rts,
                        Model model){
        String st = "Parameter is "+rts+" for god sake";
        model.addAttribute("modelKey",st);
        return "folder/param";
    }

    @GetMapping("param2")
    public String param2(@RequestParam(value = "rts",required = false) String rts){
        return "folder/param";
    }
}
