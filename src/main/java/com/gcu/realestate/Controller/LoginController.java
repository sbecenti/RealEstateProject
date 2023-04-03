package com.gcu.realestate.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.realestate.Business.SecurityServiceInterface;
import com.gcu.realestate.Model.LoginModel;


@Controller
@RequestMapping("/login") 
public class LoginController {

    @Autowired
    SecurityServiceInterface securityService;
    
    @GetMapping("/")
    public String display(Model model) {
        
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());

        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(LoginModel loginModel, BindingResult bindingResult, Model model) {

        // Check for validation errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Form");

            return "login";
        }

        // Chekc for Valid logins
        if (securityService.isAuthenticated(loginModel)) {
            model.addAttribute("model", loginModel);
            return "loginSuccess";
        }
        else {
            return "login";
        }

    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("title", "Signup Form");
        model.addAttribute("loginModel", new LoginModel());

        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(LoginModel loginModel, Model model) {
        model.addAttribute("loginModel", loginModel);
        securityService.addOne(loginModel);

            return "LoginSuccess";
    }

    
}
