package com.juyn.controllers;

import com.juyn.pojo.BillOrder;
import com.juyn.pojo.Order;
import com.juyn.service.CommonService;
import com.juyn.service.PlaceService;
import com.juyn.service.TourService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.http.HttpStatus;
//import org.apache.velocity.exception.ResourceNotFoundException;
//import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@ControllerAdvice
public class Run {
    @Autowired
    private TourService tourService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private CommonService commonService;
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @ModelAttribute
    public void commonAttri(Model model, HttpSession session) {         //Obj Session is Obj on Server
        model.addAttribute("place", this.placeService.getPlace());
        model.addAttribute("mngEmp", this.commonService.getMngEmployee());
        model.addAttribute("userId", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("totalNumOrder", ApiHandlers.countOrder((Map<Integer, Order>) session.getAttribute("order")));
        model.addAttribute("priceOrder", ApiHandlers.orderStatus((Map<Integer, Order>) session.getAttribute("order")).get("priceOrder"));
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam(value = "kw", required = false, defaultValue = "") String kw) {
        model.addAttribute("tour", this.tourService.getTour(kw, 1));
        return "baseLayout";
    }

    @GetMapping("/order")
    public String order(Model model, HttpSession session) {
        Map<Integer, Order> order = (Map<Integer, Order>) session.getAttribute("order");
        if (order != null) {
            model.addAttribute("orderByTour", new ArrayList<Order>(order.values())); //# !(List<Order>)order.values() | Parse List To GET_orderByTour[INDEX].
        } else {
            model.addAttribute("orderByTour", null);
        }
        return "tourOrder";
    }

    @GetMapping("/api/pay/{idUser}")
    @Transactional
    public String pay(HttpSession session, @PathVariable(value = "idUser") int idUser, Model model) {
        int billId = this.commonService.addReceipt((Map<Integer, Order>) session.getAttribute("order"), idUser);
        Session s = this.sessionFactory.getObject().getCurrentSession();
        if (billId != 0) {
            model.addAttribute("billInfo", (BillOrder)s.get(BillOrder.class, billId)); //this.commonService.getBill().get(billId - 1)); 'GET_INDEX'
            model.addAttribute("billDetails", this.commonService.getlistBillDetails(billId));
            session.removeAttribute("order");
            return "VnpayReturnUrl";
        } else {
            return "PayFail";
        }
    }


//    @RequestMapping("/**")
//    public String handle() {
//        return "pageNotFound";
//    }
//    @ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String handleResourceNotFoundException() {
//        return "pageNotFound";
//    }
//    @RequestMapping("/")
//    public String show(){
//        return "run";
//    }
    
    
}
