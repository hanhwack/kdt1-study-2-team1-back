package com.example.demo.productProblem.service;

import com.example.demo.productProblem.controller.form.RequestProductForm;
import com.example.demo.productProblem.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> list();

    Product register(Product product);

    Product read(Long productId);

    void delete(Long productId);

    Product modify(Long productId, RequestProductForm requestProductForm);
}
