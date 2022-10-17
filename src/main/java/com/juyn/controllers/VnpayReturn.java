package com.juyn.controllers;

import com.juyn.pojo.BillOrder;
import com.juyn.pojo.Order;
import com.juyn.service.CommonService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class VnpayReturn {
    @Autowired
    private CommonService commonService;
    
    @Autowired 
    private LocalSessionFactoryBean sessionFactory;
    
    /*@GetMapping("/returnUrl")
    public String run(@RequestParam(value = "vnp_Amount") Long amount, @RequestParam(value= "vnp_ResponseCode") String respCode, Model model){
        model.addAttribute("amount", amount/100);
        model.addAttribute("respCode", respCode);
        return "VnpayReturnUrl";//"redirect:/returnKq";
    }
    
    @RequestMapping("/returnKq")
    public String show(@RequestParam(value = "amount") String amount, @RequestParam(value = "respCode") String respCode, Model model){
        model.addAttribute("amount", amount);
        model.addAttribute("respCode", respCode);
        return "VnpayReturnUrl";
    }*/
    
    @GetMapping("/returnUrl")
    public String pay(HttpSession session, @RequestParam(value = "vnp_OrderInfo") int idUser, Model model) {
        int billId = this.commonService.addReceipt((Map<Integer, Order>) session.getAttribute("order"), idUser);
        session.removeAttribute("order");
        model.addAttribute("billId", billId);
        return "redirect:/returnKq";
    }
    
    @RequestMapping("/returnKq")
    @Transactional
    public String show(Model model, @RequestParam(value = "billId") int billId) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        if (billId != 0) {
            model.addAttribute("billInfo", (BillOrder) s.get(BillOrder.class, billId));
            model.addAttribute("billDetails", this.commonService.getlistBillDetails(billId));
            return "VnpayReturnUrl";
        } else {
            return "PayFail";
        }
    }
    
}
