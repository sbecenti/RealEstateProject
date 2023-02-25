package com.gcu.realestate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String doLogin(LoginModel loginModel, BindingResult bindingResult, Model model) {

        // Check for validation erros
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginModel", loginModel);

            return "LoginSuccess";
        }

        // Validate Logins
        String[][]validLogins = new String[][] {
            {"gcu", "1234"},
           {"username", "password"}
         };

        // Check if login is valid
        boolean success = false;
        for(int i = 0; i < validLogins.length; i++) {
          if(loginModel.getUsername().equals(validLogins[i][0]) && loginModel.getPassword().equals(validLogins[i][1])) {
                success = true;
            }
        }

        if (success) {
            model.addAttribute("loginModel", loginModel);
            return "LoginSuccess";
        }
        else {
          return "login";
        }

    }
}
