package com.gcu.realestate.Business;

import com.gcu.realestate.Model.LoginModel;

public interface SecurityServiceInterface {

    public boolean isAuthenticated(LoginModel loginModel);
    
}
