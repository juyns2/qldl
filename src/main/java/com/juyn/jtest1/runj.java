package com.juyn.jtest1;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.juyn.pojo.Product;
import com.juyn.pojo.Tour;
import com.juyn.service.CategoryService;
import com.juyn.service.ProductService;
import com.juyn.service.TourService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ControllerAdvice
public class runj {
//    @Autowired
//    private CategoryService categoryService;
//    @Autowired
//    private ProductService productService;

    @Autowired
    private TourService tourService;

//    @ModelAttribute
//    public void commonAttri(Model model) {
//        model.addAttribute("cate", this.tourService.getTour());
//    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam(value = "kw", required = false, defaultValue = "") String kw) {
        //model.addAttribute("cate", this.categoryService.getCate());
        model.addAttribute("tour", this.tourService.getTour());
        return "baseLayout";
    }

    @RequestMapping("/tour")
    public String show(Model model, @RequestParam(value = "kw", required = false, defaultValue = "") String kw) {
        model.addAttribute("prod", this.tourService.getTour());
        return "index";
    }

    @GetMapping("/admin/addTour")
    public String list(Model model) {
        model.addAttribute("tour", new Tour());
        return "add";
    }

    @PostMapping("/admin/addTour")
    public String add(@ModelAttribute(value = "prod") Tour tour) {
        if (this.tourService.addOrUpdate(tour) == true) {
            return "redirect:/tour";
        } else {
            return "add";
        }
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(value = "id") String id){
        model.addAttribute("tour", new Tour());
        model.addAttribute("id", id);
        return "edit";
    }
}
