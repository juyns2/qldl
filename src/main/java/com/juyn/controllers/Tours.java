package com.juyn.controllers;

import com.juyn.pojo.Comment;
import com.juyn.pojo.Tour;
import com.juyn.service.PlaceService;
import com.juyn.service.TourService;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Tours {

    @Autowired
    private TourService tourService;

    @Autowired
    private PlaceService placeService;

    @RequestMapping("/home/tour")
    public String show(Model model, @RequestParam(value = "kw", required = false, defaultValue = "") String kw,
            @RequestParam(required = false) Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        int placeId = Integer.parseInt(params.getOrDefault("placeId", "0"));
        if (placeId >= 1 && placeId <= 6) {
            model.addAttribute("tour", this.placeService.getPlaceTour(placeId));
        } else {
            model.addAttribute("tour", this.tourService.getTour(kw, page)); //params.get("kw")
        }
        model.addAttribute("count", this.tourService.countTour());
        model.addAttribute("page", params.get("page"));
        return "home";
    }

    @GetMapping("/admin/addTour")
    public String list(Model model) {
        model.addAttribute("tour", new Tour());
        return "tourAdd";
    }

    @PostMapping("/admin/addTour")
    public String add(@ModelAttribute(value = "tour") @Valid Tour tour, BindingResult fError) {
        if (!fError.hasErrors()) {
            if (this.tourService.addOrUpdate(tour) == true) {
                return "redirect:/home/tour";
            }
        }
        return "tourAdd";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("tour", new Tour());
        model.addAttribute("tourIndex", this.tourService.getTourIndex(id));
        model.addAttribute("id", id);
        return "tourEdit";
    }

    @PostMapping("/edit/{id}")
    public String edit(Model model, @ModelAttribute(value = "tour") Tour tour, @PathVariable(value = "id") int id) {
        if (this.tourService.edit(tour, id) == true) {
            return "redirect:/home/tour";
        } else {
            return "redirect:" + id;
        }
    }

    @RequestMapping("/tourDetails/{tourId}")
    public String tourDetails(Model model, @PathVariable(value = "tourId") int tourId) {
        model.addAttribute("tourId", this.tourService.getTourIndex(tourId));
        model.addAttribute("t", this.tourService.getTour());
        return "tourDetails";
    }

}
