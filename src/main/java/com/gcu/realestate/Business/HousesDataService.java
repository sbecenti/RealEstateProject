package com.gcu.realestate.Business;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.realestate.Model.ProductModel;
import com.gcu.realestate.Model.ProductsMapper;

@Repository
@Primary
public class HousesDataService implements HousesDAInterface {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public HousesDataService() {}

    public HousesDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void test() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'test'");
    }
    @Override
    public List<ProductModel> getHouses() {
        return jdbcTemplate.query("select * from PROPERTIES", new ProductsMapper());
    }
    @Override
    public ProductModel getOne(Long id) {
        return jdbcTemplate.queryForObject("select * from PROPERTIES where id = ?", new ProductsMapper(), new Object[]{id});
    }
    @Override
    public List<ProductModel> searchProduct(String searchTerm) {
        return jdbcTemplate.query("select * from PROPERTIES where NAME_OF_PROPERTY LIKE ?", new ProductsMapper(), new Object[]{"%" + searchTerm + "%"});
    }
    @Override
    public int addOne(ProductModel newProduct) {
        return jdbcTemplate.update("insert into PROPERTIES (NAME_OF_PROPERTY, LOCATION, DATE_OF_CONSTRUCTION, PHOTO_FILE_NAME, DESCRIPTION, VALUE, SQUARE_FEET, NUMBER_BATHS, NUMBER_BEDROOMS, ID) values (?,?,?,?,?,?,?,?,?,?)",
            newProduct.getNameOfProperty(),
            newProduct.getLocation(),
            newProduct.getDateOfConstruction(),
            newProduct.getPhotoFileName(),
            newProduct.getDescription(),
            newProduct.getValue(),
            newProduct.getSquareFeet(),
            newProduct.getNumBaths(),
            newProduct.getNumBRooms(),
            newProduct.getId()
            );
    }
    @Override
    public boolean deleteOne(long id) {
        int updateResult = jdbcTemplate.update("delete from PROPERTIES where id = ?", new Object[]{id});
        return (updateResult > 0);
    }
    @Override
    public ProductModel updateOne(long idToUpdate, ProductModel updateOrder) {
        int result = jdbcTemplate.update("update PROPERTIES set NAME_OF_PROPERTY = ?, LOCATION = ?, DATE_OF_CONSTRUCTION = ?, PHOTO_FILE_NAME = ?, DESCRIPTION = ?, VALUE = ?, SQUARE_FEET = ?, NUMBER_BATHS = ?, NUMBER_BEDROOMS = ? where id = ?",
            updateOrder.getNameOfProperty(),
            updateOrder.getLocation(),
            updateOrder.getDateOfConstruction(),
            updateOrder.getPhotoFileName(),
            updateOrder.getDescription(),
            updateOrder.getValue(),
            updateOrder.getSquareFeet(),
            updateOrder.getNumBaths(),
            updateOrder.getNumBRooms(),
            idToUpdate
            );
            if (result > 0) {
                return updateOrder;
            }
            else {
                return null;
            }
    }
    @Override
    public void init() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'init'");
    }
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

    


}
