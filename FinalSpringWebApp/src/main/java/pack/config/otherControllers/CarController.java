package pack.config.otherControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pack.DAO.CarDAO;
import pack.models.Car;

import javax.validation.Valid;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping()
    public String showAll(Model model){
        model.addAttribute("autos",carDAO.fullList());
        return "cars";
    }

    @GetMapping("/{what}")
    public String showOne(@PathVariable("what") int what, Model model){
        model.addAttribute("auto",carDAO.showOneCar(what));
        return "onecar";
    }

/**    @GetMapping("/new")
//    public String newCar(Model model){
//        model.addAttribute("auto",new Car());
//        return "newcar";
   } */

    @GetMapping("/new")
    public String newCar(@ModelAttribute("auto")Car car){
//        model.addAttribute("auto",new Car());
        return "newcar";
    }

    @PostMapping()
    public String addCar(@ModelAttribute("auto") @Valid Car auto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "newcar";
        carDAO.add(auto);
        return "redirect:/cars";
    }

    @GetMapping("/{what}/change")
    public String editCar(Model model, @PathVariable("what") int what){
        model.addAttribute("auto",carDAO.showOneCar(what));
        return "editcar";
    }

    @PatchMapping("/{what}")
    public String patchEditCar(@ModelAttribute("auto") @Valid Car car, BindingResult bindingResult,
                               @PathVariable("what") int what){
        if (bindingResult.hasErrors()) return "editcar";
        carDAO.patchEdit(what,car);
        return "redirect:/cars";
    }

    @DeleteMapping("/{what}")
    public String deleteCar(@PathVariable("what") int what){
        carDAO.deleteCar(what);
        return "redirect:/cars";
    }
}