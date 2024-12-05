package com.cybersolf.demorestfulapi.controller;

import com.cybersolf.demorestfulapi.model.ProductEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public ResponseEntity<?> getProduct(){
        List<ProductEntity> products = new ArrayList<>();
        ProductEntity product = new ProductEntity();
        product.setTitle("San Pham 1");
        product.setPrice(14.5);
        product.setRate(24.2);

        List<PolicyEntity> policies = new ArrayList<>();
        PolicyEntity policy = new PolicyEntity();
        policy.setTitle("abc");
        policy.setDescription("dung ok khong");
        policies.add(policy);
        product.setPolicies(policies);

        ProductEntity product2 = new ProductEntity();
        product2.setTitle("San Pham 2");
        product2.setPrice(44.5);
        product2.setRate(33.2);
        products.add(product);
        products.add(product2);
        return ResponseEntity.ok(products);
    }
}
