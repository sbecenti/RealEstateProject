package com.gcu.realestate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.realestate.Business.HousesService;
import com.gcu.realestate.Business.HousesServiceInterface;

@Configuration
public class SpringConfig {
    
    @Bean(name="HousesService")
    public HousesServiceInterface getHouses() {
        return new HousesService();
    }

}
