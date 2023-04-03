package com.gcu.realestate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.gcu.realestate.Business.HousesDAInterface;
import com.gcu.realestate.Business.HousesDataService;
import com.gcu.realestate.Business.HousesService;
import com.gcu.realestate.Business.HousesServiceInterface;
import com.gcu.realestate.Business.SecurityServiceInterface;
import com.gcu.realestate.Business.ValidLogins;

@Configuration
public class SpringConfig {

    @Bean(name="housesService")
    public HousesServiceInterface getHouses() {
        return new HousesService();
    }

    @Bean(name="housesDAO1")
    public HousesDAInterface getDataSource() {
        return new HousesDataService();
    }

    @Bean(name="securityService")
    public SecurityServiceInterface getSecurityService() {
        return new ValidLogins();
    }

}
