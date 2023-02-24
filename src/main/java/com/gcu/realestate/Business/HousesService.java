package com.gcu.realestate.Business;

import java.util.List;
import java.util.ArrayList;

import com.gcu.realestate.Model.ProductModel;

public class HousesService implements HousesServiceInterface {
    
    @Override
    public void test() {
        System.out.println("HousesService test() is working");
    }

    @Override
    public List<ProductModel> getHouses() {
        
        List<ProductModel> houses = new ArrayList<ProductModel>();
        houses.add(new ProductModel("Test House", "Test Location", "3-2-2002", "test.img", "test description", 3200000.00, 8243, 7, 7, 0L));

        return houses;
    }

    @Override
    public ProductModel getOne(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @Override
    public List<ProductModel> searchProduct(String searchTerm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchProduct'");
    }

    @Override
    public int addOne(ProductModel newProduct) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addOne'");
    }

    @Override
    public boolean deleteOne(long l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOne'");
    }

    @Override
    public ProductModel updateOne(long idToUpdate, ProductModel updateOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOne'");
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
