package com.gcu.realestate.Business;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.realestate.Model.LoginMapper;
import com.gcu.realestate.Model.LoginModel;

@Repository
public class LoginDataService implements SecurityServiceInterface {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public LoginDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<LoginModel> getLogins() {
        return jdbcTemplate.query("select * from ACCOUNTS", new LoginMapper());
    }

    @Override
    public int addOne(LoginModel newLogin) {
        return jdbcTemplate.update("insert into ACCOUNTS (USERNAME, PASSWORD) values (?,?)",
            newLogin.getUsername(),
            newLogin.getPassword()
        );
    }

    @Override
    public boolean isAuthenticated(LoginModel loginModel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAuthenticated'");
    }
    
}
