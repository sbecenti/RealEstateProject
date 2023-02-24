package com.gcu.realestate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



import com.gcu.realestate.Model.LoginModel;


@Controller
@RequestMapping("/login") 
public class LoginController {
    
    @GetMapping("/")
    public String display(Model model) {
        
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());

        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(LoginModel loginModel, Model model) {

        model.addAttribute("loginModel", loginModel);

        return "LoginSuccess";
    }

}
