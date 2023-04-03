package com.gcu.realestate.Business;

import java.util.List;

import com.gcu.realestate.Model.LoginModel;

public interface SecurityServiceInterface {

    public boolean isAuthenticated(LoginModel loginModel);
    public List<LoginModel> getLogins();
    public int addOne(LoginModel loginModel);
    
}
