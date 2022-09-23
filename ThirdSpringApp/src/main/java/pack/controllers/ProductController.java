package pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pack.DAO.ProductDAO;
import pack.model.Product;

import javax.validation.Valid;

@Controller
@RequestMapping("/prod")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("one", productDAO.getOne(id));
        return "oneProduct";
    }

    @GetMapping("all")
    public String getAll(Model model) {
        model.addAttribute("all", productDAO.getAll());
        return "allProducts";
    }

    @GetMapping("new")
    public String newProd(@ModelAttribute("newProd") Product product
//            Model model
    ) {
//        model.addAttribute("newProd", new Product());
        return "newProduct";
    }

    @PostMapping()
    public String create(@ModelAttribute("newProd") @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "newProduct";
        ProductDAO.save(product);
        return "redirect:/prod/all";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("editProd", ProductDAO.getOne(id));
        return "editProduct";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("editProd") Product product, @PathVariable("id") int id) {
        ProductDAO.update(id, product);
        return "redirect:/prod/all";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        ProductDAO.delete(id);
        return "redirect:/prod/all";
    }

}