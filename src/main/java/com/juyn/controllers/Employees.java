package com.juyn.controllers;

import com.juyn.service.CommonService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Employees {
    
    @Autowired
    private CommonService commonService;
    
    @GetMapping("/emp/showinfo") // /{path}
    public String show(Model model, @RequestParam Map<String, String> params){ //@PathVariable(value = "path") String path,
        model.addAttribute("empType", params.get("empType")  );
        model.addAttribute("emp", this.commonService.getEmp(params));
        return "empInfo";
    }
    
    @GetMapping("/emp/edit/{id}")
    public String edit(){
        return "empEdit";
    }
    
    @GetMapping("/emp/detail/{id}")
    public String Detail(){
        return "empDetails";
    }
    
    
}
