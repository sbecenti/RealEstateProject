package com.gcu.realestate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.realestate.Model.LoginModel;


@Controller
@RequestMapping("/register")
public class RegistrationController {
    
    @GetMapping("/")
    public String display(Model model) {
        
        model.addAttribute("title", "Sign Up");
        model.addAttribute("loginModel", new LoginModel());

        return "registerForm";
    }

}
