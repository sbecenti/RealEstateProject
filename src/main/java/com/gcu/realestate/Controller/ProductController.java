package com.gcu.realestate.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.realestate.Business.HousesServiceInterface;
import com.gcu.realestate.Model.ProductModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/houses")
public class ProductController {

    @Autowired
    private HousesServiceInterface housesService;
    
    @GetMapping("/")
    public String showAllHouses(Model model) {
        
        // Get Houses
        List<ProductModel> houses = housesService.getHouses();

        // Display houses html
        model.addAttribute("title", "Properties available");
        model.addAttribute("houses", houses);

        return "houses";
    }

    

    @GetMapping("/{id}")
    public String getOne(@PathVariable(name="id") Long id, Model model) {

        ProductModel house = housesService.getOne(id);

        // Display houses html
        model.addAttribute("title", "Properties available");
        model.addAttribute("houses", house);

        return "houses";
    }

    @GetMapping("/search/{searchTerm}")
    public String searchProduct(@PathVariable(name="searchTerm") String searchTerm, Model model) {

        List<ProductModel> foundItems = housesService.searchProduct(searchTerm);

        // Display houses html
        model.addAttribute("title", "Properties available");
        model.addAttribute("houses", foundItems);

        return "houses";
    }

    @GetMapping("/new")
    public String proccessAddOne(Model model) {
        model.addAttribute("title", "Data Input Form");
        model.addAttribute("productModel", new ProductModel());

        return "DataInputForm";
    }

    @PostMapping("/processInput")
    public String addOne(ProductModel productModel) {

        housesService.addOne(productModel);

        return "DataInputSuccess";

    }

    @GetMapping("/edit/{id}")
    public String updateOne(@PathVariable(value = "id") Long id, Model model) {

        ProductModel productModel = housesService.getHouses().stream().filter(p -> p.getId() == id).findFirst().get();
        
        model.addAttribute("productModel", productModel);
        
        return "DataEditForm";
    }

    @PostMapping("/processEdit")
    public String processEdit(ProductModel productModel) {

        ProductModel houseToEdit = housesService.getHouses().stream().filter(p -> p.getId() == productModel.getId()).findFirst().get();

        housesService.updateOne(houseToEdit.getId(), productModel);

        return "redirect:/houses/";


    }

    @PostMapping("/delete/{id}")
    public String deleteOne(@PathVariable(value = "id") Long id, ProductModel model) {

        ProductModel houseToDelete = housesService.getHouses().stream().filter(p -> p.getId() == model.getId()).findFirst().get();
        
        housesService.deleteOne(houseToDelete.getId());

        return "redirect:/houses/";
    }

    

}
