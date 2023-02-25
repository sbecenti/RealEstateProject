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
import org.springframework.web.bind.annotation.RestController;


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
    public String getOne(@PathVariable(name="id") int id, Model model) {

        ProductModel house = housesService.getOne(id);

        // Display houses html
        model.addAttribute("title", "Properties available");
        model.addAttribute("houses", house);

        return "houses";
    }

}
