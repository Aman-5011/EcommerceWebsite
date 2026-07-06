package com.aman.SpringEcom.service;

import com.aman.SpringEcom.model.Product;
import com.aman.SpringEcom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productrepo;

    public List<Product> getAllProducts() {
        return productrepo.findAll();
    }

    public Product getProductById(int id) {
        return productrepo.findById(id).orElse(null);
    }

    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return productrepo.save(product);
    }

    public void deleteProduct(int id) {
        productrepo.deleteById(id);
    }

    public List<Product> searchProduct(String value) {
        return productrepo.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrBrandContainingIgnoreCaseOrCategoryContainingIgnoreCase(value,value,value,value);
    }
}
