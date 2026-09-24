package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(Integer id){
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Product addNewProduct(@Valid @RequestBody Product product){
        return productService.addNewProduct(product);
    }

    @PutMapping("/products")
    public Product updateProduct(Integer id, Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/products")
    public void deleteProduct(Integer id){
        productService.deleteProductByID(id);
    }
}
