package ru.omsu.imit.controllers;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.omsu.imit.model.Product;
import ru.omsu.imit.repositories.ProductAdminRepository;
import ru.omsu.imit.repositories.ProductRepository;
import ru.omsu.imit.requests.InsertProductRequest;
import ru.omsu.imit.requests.UpdateProductRequest;

@Controller
@RequestMapping("/")
public class MainController {
    Gson GSON = new Gson();

    @Autowired
    private ProductAdminRepository productAdminRepository;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(path = "/{barcode}", method = RequestMethod.GET)
    @ResponseBody
    public String getProduct(@PathVariable("barcode") long barcode) {
        Product product = productRepository.getByBarcode(barcode);

        if (product == null) {
            return GSON.toJson(new Exception("Product with specified barcode wasn't found"));
        }

        return GSON.toJson(product);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String insertProduct(@RequestBody InsertProductRequest request) {
        Product prodToInsert = new Product();
        prodToInsert.setBarcode(request.getBarcode());
        prodToInsert.setProductName(request.getProductName());
        prodToInsert.setBrandName(request.getBrandName());
        this.productRepository.insert(prodToInsert);

        Product response = this.productRepository.getByBarcode(request.getBarcode());
        return GSON.toJson(response);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String updateProduct(@RequestBody UpdateProductRequest request) {
        Product prodToUpdate = new Product();
        prodToUpdate.setBarcode(request.getBarcode());
        prodToUpdate.setProductName(request.getProductName());
        prodToUpdate.setBrandName(request.getBrandName());
        this.productAdminRepository.updateProduct(prodToUpdate);

        Product response = this.productRepository.getByBarcode(request.getBarcode());
        return GSON.toJson(response);
    }


}
