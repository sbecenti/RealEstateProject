package com.gcu.realestate.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.realestate.Model.LoginModel;

public class ValidLogins implements SecurityServiceInterface {
    
    @Autowired
    LoginDataService loginDAO;

    @Override
    public boolean isAuthenticated(LoginModel loginModel) {
        
        // List of valid logins
        List<LoginModel> validLogins = loginDAO.getLogins();

        // Check if login matches a valid login
        boolean success = false;
        for (int i = 0; i < validLogins.size(); i++) {
            if (loginModel.getUsername().equals(validLogins.get(i).getUsername()) && loginModel.getPassword().equals(validLogins.get(i).getPassword())) {
                success = true;
            }
        }
        if (success) {
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public List<LoginModel> getLogins() {
        return loginDAO.getLogins();
    }

    @Override
    public int addOne(LoginModel loginModel) {
        return loginDAO.addOne(loginModel);
    }

}
