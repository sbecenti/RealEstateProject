package com.gcu.realestate.Business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gcu.realestate.Model.ProductModel;

@Repository
public class HousesDAO implements HousesDAInterface {

    private List<ProductModel> houses = new ArrayList<ProductModel>();

    public HousesDAO() {
        houses = new ArrayList<ProductModel>();

        houses.add(new ProductModel("Test House0", "Test Location0", "3-2-2002", "test.img", "test description", 3200000.00, 8243, 7, 7, 0L));
        houses.add(new ProductModel("Test House1", "Test Location1", "3-2-2002", "test.img", "test description", 3200000.00, 8243, 7, 7, 1L));
        houses.add(new ProductModel("Test House2", "Test Location2", "3-2-2002", "test.img", "test description", 3200000.00, 8243, 7, 7, 2L));
        houses.add(new ProductModel("Test House3", "Test Location3", "3-2-2002", "test.img", "test description", 3200000.00, 8243, 7, 7, 3L));

    }

    @Override
    public void test() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'test'");
    }

    @Override
    public List<ProductModel> getHouses() {
        return houses;
    }

    @Override
    public ProductModel getOne(Long id) {
        
        for(int i = 0; i < houses.size(); i++) {
            if (houses.get(i).getId() == id) {
                return houses.get(i);
            }
        }
        return null;
    }

    @Override
    public List<ProductModel> searchProduct(String searchTerm) {
        //Searches for search term
        List<ProductModel> foundItems = new ArrayList<ProductModel>();
        for (int i = 0; i < houses.size(); i++) {
            if (houses.get(i).getNameOfProperty().toLowerCase().contains(searchTerm.toLowerCase())) {
                foundItems.add(houses.get(i));
            }
        }
        return foundItems;
    }

    @Override
    public int addOne(ProductModel newProduct) {
        boolean success = houses.add(newProduct);
        // For testing
        System.out.println("I added one item. Now there are " + houses.size() + " items in the list");
        if (success) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean deleteOne(long id) {
        houses.removeIf(house -> house.getId() == id);
        // For testing
        System.out.println("I removed one item. Now there are " + houses.size() + " items in the list");
        return true;
    }

    @Override
    public ProductModel updateOne(long idToUpdate, ProductModel update) {
        
        for(int i = 0; i < houses.size(); i++) {
            if (houses.get(i).getId() == idToUpdate) {
                houses.get(i).setNameOfProperty(update.getNameOfProperty());
                houses.get(i).setLocation(update.getLocation());
                houses.get(i).setDateOfConstruction(update.getDateOfConstruction());
                houses.get(i).setPhotoFileName(update.getPhotoFileName());
                houses.get(i).setDescription(update.getDescription());
                houses.get(i).setValue(update.getValue());
                houses.get(i).setSquareFeet(update.getSquareFeet());
                houses.get(i).setNumBaths(update.getNumBaths());
                houses.get(i).setNumBRooms(update.getNumBRooms());
                System.out.println("Updated product: " + update);
                return update;
            }
        }
        // If nothing is found
        System.out.println("Could not find product");
        return null;
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
