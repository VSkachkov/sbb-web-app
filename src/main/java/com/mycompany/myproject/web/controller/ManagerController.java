package com.mycompany.myproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
@RequestMapping("/management")
public class ManagerController {

    @GetMapping(value = "/managerLink")
    public String goManagerPage(//Model model, @ModelAttribute("productForm") ProductAttribute productForm
   //         , @ModelAttribute("user") SessionUser user
    ) {


        return "managerPage";
    }


}
