package com.example.SpringEcom.service;

import com.example.SpringEcom.model.Product;
import com.example.SpringEcom.repo.EcomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private EcomRepo repo;


    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product saveOrUpdateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return repo.save(product);
    }

    public void deleteProduct(Product deleteProduct) {
        repo.delete(deleteProduct);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchKeyword(keyword);
    }
}
