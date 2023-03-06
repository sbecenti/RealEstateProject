package com.gcu.realestate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.realestate.Business.HousesService;
import com.gcu.realestate.Business.HousesServiceInterface;
import com.gcu.realestate.Business.SecurityServiceInterface;
import com.gcu.realestate.Business.ValidLogins;

@Configuration
public class SpringConfig {
    
    @Bean(name="HousesService")
    public HousesServiceInterface getHouses() {
        return new HousesService();
    }

    @Bean(name="securityService")
    public SecurityServiceInterface getSecurityService() {
        return new ValidLogins();
    }

}
