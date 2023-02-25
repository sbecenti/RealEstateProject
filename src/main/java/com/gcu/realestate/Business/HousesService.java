package com.gcu.realestate.Business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.realestate.Model.ProductModel;

public class HousesService implements HousesServiceInterface {
    
    //Uses dependecy injection
    @Autowired
    HousesDAInterface housesDAO;
    
    @Override
    public void test() {
        System.out.println("HousesService test() is working");
    }

    @Override
    public List<ProductModel> getHouses() {
        return housesDAO.getHouses();
    }

    @Override
    public ProductModel getOne(int id) {
       return housesDAO.getOne(id);
    }

    @Override
    public List<ProductModel> searchProduct(String searchTerm) {
        return housesDAO.searchProduct(searchTerm);
    }

    @Override
    public int addOne(ProductModel newProduct) {
        return housesDAO.addOne(newProduct);
    }

    @Override
    public boolean deleteOne(long l) {
        return housesDAO.deleteOne(l);
    }

    @Override
    public ProductModel updateOne(long idToUpdate, ProductModel updateOrder) {
        return housesDAO.updateOne(idToUpdate, updateOrder);
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
