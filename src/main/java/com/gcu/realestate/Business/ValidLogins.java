package com.gcu.realestate.Business;

import com.gcu.realestate.Model.LoginModel;

public class ValidLogins implements SecurityServiceInterface {
    
    @Override
    public boolean isAuthenticated(LoginModel loginModel) {
        
        // List of valid logins
        String[][] validLogins = new String [][] {
            {"username", "password"},
            {"gcu", "1234"},
            {"Spring", "Boot"},
        };

        // Check if login matches a valid login
        boolean success = false;
        for (int i = 0; i < validLogins.length; i++) {
            if (loginModel.getUsername().equals(validLogins[i][0]) && loginModel.getPassword().equals(validLogins[i][1])) {
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

}
