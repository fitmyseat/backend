package com.fitmyseat.seat.service;

import com.fitmyseat.seat.entity.Product;
import com.fitmyseat.seat.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        product.setCreatedAt(LocalDateTime.now());
      
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setVehicleName(productDetails.getVehicleName());
            product.setModel(productDetails.getModel());
            product.setColor(productDetails.getColor());
            product.setStitch(productDetails.getStitch());
            product.setPrice(productDetails.getPrice());
            product.setImageUrl(productDetails.getImageUrl());
            product.setCloudinaryPublicId(productDetails.getCloudinaryPublicId());
            product.setQuantity(productDetails.getQuantity());
            return productRepository.save(product);
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
