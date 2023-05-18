package com.example.demo.productProblem.service;

import com.example.demo.productProblem.controller.form.RequestProductForm;
import com.example.demo.productProblem.entity.Product;
import com.example.demo.productProblem.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    final private ProductRepository productRepository;

    @Override
    public List<Product> list() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }

    @Override
    public Product register(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product read(Long productId) {
        Optional<Product> maybeProduct = productRepository.findById(productId);

        if (maybeProduct.isEmpty()) {
            log.info("해당 상품이 없습니다");
            return null;
        }
        return maybeProduct.get();
    }

    @Override
    public void delete(Long productId) {
//        Optional<Product> maybeProduct = productRepository.findById(productId);
//
//        if (maybeProduct.isEmpty()) {
//            log.info("해당 상품이 없습니다");
//        }
        productRepository.deleteById(productId);
    }

    @Override
    public Product modify(Long productId, RequestProductForm requestProductForm) {
        Optional<Product> maybeProduct = productRepository.findById(productId);

        if (maybeProduct.isEmpty()) {
            log.info("해당 상품이 없습니다");
            return null;
        }

        Product product = maybeProduct.get();
        product.setName(requestProductForm.getName());
        product.setManufacturer(requestProductForm.getManufacturer());
        product.setPrice(requestProductForm.getPrice());
        product.setCategory(requestProductForm.getCategory());
        product.setManufacturedDate(requestProductForm.getManufacturedDate());
        product.setExpireDate(requestProductForm.getExpireDate());

        return productRepository.save(product);
    }
}
