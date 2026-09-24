package com.example.ecommerce.service;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.exception.ProductNotFound;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //Get All Product
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    //Find Product by ID
    public Product getProductById(Integer id){
        return productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFound("This Product with this ID is not Available"));
    }

    //Updating the existing Product
    public Product updateProduct(Integer id, Product updatedProduct){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFound("This Product ID is not Available"));
        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setProductId(updatedProduct.getProductPrice());

        return productRepository.save(existingProduct);
    }

    //Deleting the Product
    public void deleteProductByID(Integer id){
        productRepository.deleteById(id);
    }
}
