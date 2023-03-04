package com.gcu.realestate.Business;

import java.util.List;

import com.gcu.realestate.Model.ProductModel;

public interface HousesServiceInterface {
    
    public void test();
    public List<ProductModel> getHouses();
    public ProductModel getOne(Long id);
    public List<ProductModel> searchProduct(String searchTerm);
    public int addOne(ProductModel newProduct);
    public boolean deleteOne(long l);
    public ProductModel updateOne(long idToUpdate, ProductModel updateOrder);
    public void init();
    public void destroy();



}
