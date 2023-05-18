package com.example.demo.productProblem.controller.form;

import com.example.demo.productProblem.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class RequestProductForm {
    final private String name;
    final private String manufacturer;
    final private String price;
    final private String category;
    final private String manufacturedDate;
    final private String expireDate;

    public Product toProduct() {
        return new Product(name, manufacturer, price, category, manufacturedDate, expireDate);
    }
}
