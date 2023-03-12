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

        houses.add(new ProductModel("New York estate", "6423 Alderton St, Flushing, NY 11374", "1930", "/img/NewYorkHouse1.png", "This 1800 square foot multi family home has 3 bedrooms and 2.0 bathrooms. This home is located at 6423 Alderton St, Flushing, NY 11374.", 1365000.00, 1800, 2, 3, 0L));
        houses.add(new ProductModel("Lake Travis Texas waterfront estate", "211 Costa Bella Dr, Austin, TX 78734", "2001", "/img/TexasHouse1.png", "Majestic, close-in Lake Travis waterfront estate on 3.24 delightfully manicured acres in the gated resort community of Costa Bella beckons those who appreciate only the finest craftsmanship and detail.", 7950000, 9261, 8, 6, 1L));
        houses.add(new ProductModel("Palisades Riviera California estate", "1678 Alta Mura Rd, Pacific Palisades, CA 90272", "2005", "/img/CaliforniaHouse1.png", "The most spectacular estate in the premier section of the Palisades Riviera with the most incredible views of any home on the west side. This 1.13 acre compound has a 13,000 square-foot main house and a truly special 3000 square-foot guesthouse. This is one of the greatest estates in Los Angeles!", 64000000.00, 16000, 14, 8, 2L));
        houses.add(new ProductModel("Luxury Carnarvon Drive Texas Estate", "100 Carnarvon Dr, Houston, TX 77024", "2002", "/img/TexasHouse2.png", "The height of luxury and palatial opulence await you in this exclusive estate on well-known Carnarvon Drive. Discover a grandeur and ambiance unlike any other. Interior design, contributed by renowned David Easton, is a modern neoclassical property with impressionistic French design that would evoke classic, timeless elegance for all who visit.", 36000000.00, 26401, 12, 8, 3L));
        houses.add(new ProductModel("New York Penthouse", "53 W 53rd St PENTHOUSE 76, New York, NY 10019", "2019", "/img/NewYorkHouse2.png", "This 7973 square foot condo home has 4 bedrooms and 4.0 bathrooms. Offering 360 views of New York City from the clouds.", 63815000.00, 7973, 4, 4, 4L));
        houses.add(new ProductModel("Beverly Hills California estate", "1024 Summit Dr, Beverly Hills, CA 90210", "1924", "/img/CaliforniaHouse2.png", "Flawlessly executed, an estate of ultimate exclusivity on nearly an acre of privately-gated land, this trophy property was built by architect William Beckett to capture an architectural escape while boasting the most luxurious of amenities and sited in prime Beverly Hills. ", 19999000.00, 12000, 9, 7, 5L));

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
