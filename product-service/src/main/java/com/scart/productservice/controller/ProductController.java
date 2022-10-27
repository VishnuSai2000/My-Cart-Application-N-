package com.scart.productservice.controller;

import com.scart.productservice.model.Product;
import com.scart.productservice.service.ProductService;
import com.scart.productservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public Product addProducts(@RequestBody Product product) {
        return productService.addProducts(product);
    }

    @GetMapping("/view")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/update/{id}")
    public Product updateProducts(@RequestBody Product product, @PathVariable("id") int productId) {
        return productService.updateProducts(product, productId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductsById(@PathVariable("id") int productId) {
        productService.deleteProductsById(productId);
    }
    @GetMapping("/getbycategory/{category}")
    public List<Product> getProductsByCategory(@PathVariable() String category){
        return productService.getProductByCategory(category);
    }
    @GetMapping("/getbyproductname/{productName}")
    public Optional<Product>  getProductByName(@PathVariable() String productName){
        return productService.getProductByName(productName);
    }

}
