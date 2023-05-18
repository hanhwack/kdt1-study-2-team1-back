package com.example.demo.productProblem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Setter
    private String name;
    @Setter
    private String manufacturer;
    @Setter
    private String price;
    @Setter
    private String category;
    @Setter
    private String manufacturedDate;
    @Setter
    private String expireDate;

    public Product(String name, String manufacturer, String price, String category, String manufacturedDate, String expireDate) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.category = category;
        this.manufacturedDate = manufacturedDate;
        this.expireDate = expireDate;
    }
}
