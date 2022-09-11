package com.juyn.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.juyn.pojo.Product;
import com.juyn.pojo.Tour;
import com.juyn.service.CategoryService;
import com.juyn.service.PlaceService;
import com.juyn.service.ProductService;
import com.juyn.service.TourService;
import java.io.IOException;
import java.util.Map;
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
public class Run {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @Autowired
    private TourService tourService;

    @Autowired
    private PlaceService placeService;

    @ModelAttribute
    public void commonAttri(Model model) {
        model.addAttribute("place", this.placeService.getPlace());
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam(value = "kw", required = false, defaultValue = "") String kw) {
        //model.addAttribute("cate", this.categoryService.getCate());
        model.addAttribute("tour", this.tourService.getTour(kw, 1));
        return "baseLayout";
    }

    @RequestMapping("/home/tour")
    public String show(Model model, @RequestParam(value = "kw", required = false, defaultValue = "") String kw,
            @RequestParam(required = false) Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("tour", this.tourService.getTour(kw, page)); //params.get("kw")
        model.addAttribute("count", this.tourService.countTour());
        model.addAttribute("page", params.get("page"));
        return "home";
    }

    @GetMapping("/admin/addTour")
    public String list(Model model) {
        model.addAttribute("tour", new Tour());
        return "add";
    }

    @PostMapping("/admin/addTour")
    public String add(@ModelAttribute(value = "tour") Tour tour) {
        if (this.tourService.addOrUpdate(tour) == true) {
            return "redirect:/home/tour";
        } else {
            return "add";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("tour", new Tour());
        model.addAttribute("tourIndex", this.tourService.getTourIndex(id));
        model.addAttribute("id", id);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute(value = "tour") Tour tour, @PathVariable(value = "id") int id) {

        if (this.tourService.edit(tour, id) == true) {
            return "redirect:/home/tour";
        } else {
            return "redirect:" + id;
        }
    }
    
}
