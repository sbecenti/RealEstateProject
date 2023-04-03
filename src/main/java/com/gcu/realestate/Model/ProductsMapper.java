package com.gcu.realestate.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsMapper implements RowMapper<ProductModel> {

    /* match the property names in OrderModel with the column names in the database
     
    Class               Table
    Properties          Column Names 
    ================================
    id                  ID
    nameOfProperty      Name_OF_PROPERTY
    location            LOCATION
    dateOfConstruction  DATE_OF_CONSTRUCTION
    photoFileName       PHOTO_FILE_NAME
    description         DESCRIPTION
    value               VALUE 
    squareFeet          SQUARE_FEET
    numBaths            NUMBER_BATHS
    numBRooms           NUMBER_BEDROOMS

     */

    public ProductModel mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductModel product = new ProductModel(resultSet.getString("NAME_OF_PROPERTY"), resultSet.getString("LOCATION"), resultSet.getString("DATE_OF_CONSTRUCTION"), resultSet.getString("PHOTO_FILE_NAME"), resultSet.getString("DESCRIPTION"), resultSet.getDouble("VALUE"), resultSet.getInt("SQUARE_FEET"), resultSet.getInt("NUMBER_BATHS"), resultSet.getInt("NUMBER_BEDROOMS"), resultSet.getLong("ID"));
        return product;
    }
    
}
