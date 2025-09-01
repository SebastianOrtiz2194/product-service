package com.example.productservice.service;
import com.example.productservice.dto.*;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
@Service
public class ProductService {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository){this.repository = repository;}
    @Transactional public ProductResponse createProduct(ProductRequest req){
        Product p = new Product();p.setName(req.name());p.setDescription(req.description());
        p.setPrice(req.price());p.setStock(req.stock());p.setSku(req.sku());
        repository.save(p);return toResponse(p);
    }
    @Transactional(readOnly=true) public List<ProductResponse> listProducts(){
        return repository.findAll().stream().map(this::toResponse).toList();
    }
    @Transactional(readOnly=true) public ProductResponse getProduct(UUID id){
        return repository.findById(id).map(this::toResponse)
            .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }
    @Transactional public ProductResponse updateProduct(UUID id, ProductRequest req){
        Product p = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found"));
        p.setName(req.name());p.setDescription(req.description());p.setPrice(req.price());p.setStock(req.stock());p.setSku(req.sku());
        repository.save(p);return toResponse(p);
    }
    @Transactional public void deleteProduct(UUID id){repository.deleteById(id);}
    private ProductResponse toResponse(Product p){return new ProductResponse(p.getId(),p.getName(),p.getDescription(),p.getPrice(),p.getStock(),p.getSku(),p.getCreatedAt(),p.getUpdatedAt());}
}