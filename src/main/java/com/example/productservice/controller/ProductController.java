package com.example.productservice.controller;
import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {this.productService = productService;}
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody @Valid ProductRequest req) {return productService.createProduct(req);}
    @GetMapping
    public List<ProductResponse> list() {return productService.listProducts();}
    @GetMapping("/{id}")
    public ProductResponse get(@PathVariable UUID id) {return productService.getProduct(id);}
    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable UUID id, @RequestBody @Valid ProductRequest req) {return productService.updateProduct(id, req);}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {productService.deleteProduct(id);}
}