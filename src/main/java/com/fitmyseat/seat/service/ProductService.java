package com.fitmyseat.seat.service;

import com.fitmyseat.seat.entity.Product;
import com.fitmyseat.seat.entity.Sales;
import com.fitmyseat.seat.repository.ProductRepository;
import com.fitmyseat.seat.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final SalesRepository salesRepository;

    public ProductService(ProductRepository productRepository, SalesRepository salesRepository) {
        this.productRepository = productRepository;
        this.salesRepository = salesRepository;
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

    public Product decrementQuantity(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            Integer currentQuantity = product.getQuantity();
            if (currentQuantity != null && currentQuantity > 0) {
                product.setQuantity(currentQuantity - 1);
                Product updatedProduct = productRepository.save(product);

                // Create sales record
                Sales sales = new Sales();
                sales.setVehicleName(product.getVehicleName());
                sales.setModel(product.getModel());
                sales.setColor(product.getColor());
                sales.setStitch(product.getStitch());
                sales.setQuantity(1);
                sales.setUnitPrice(product.getPrice());
                sales.setTotalPrice(product.getPrice());
                sales.setProductId(product.getId());
                sales.setPartyName("Walk-in Customer"); // Default party name
                salesRepository.save(sales);

                return updatedProduct;
            }
        }
        return null;
    }
}
