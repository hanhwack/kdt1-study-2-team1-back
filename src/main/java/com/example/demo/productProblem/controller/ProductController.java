package com.example.demo.productProblem.controller;

import com.example.demo.productProblem.controller.form.RequestProductForm;
import com.example.demo.productProblem.entity.Product;
import com.example.demo.productProblem.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("product-problem")
public class ProductController {

    final private ProductService productService;

    @GetMapping("/list")
    public List<Product> productList() {
        log.info("productList()");

        List<Product> returnedProductList = productService.list();
        
        final UUID uniqueId = UUID.randomUUID();
        
        return returnedProductList;
    }

    @PostMapping("/register")
    public Product registerProduct (@RequestBody RequestProductForm requestProductForm) {
        log.info("registerProduct()");

        return productService.register(requestProductForm.toProduct());
    }
    @GetMapping("/{productId}")
    public Product readProduct(@PathVariable("productId") Long productId) {
        log.info("viewProduct()");

        return productService.read(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct (@PathVariable("productId") Long productId) {
        productService.delete(productId);
    }

    @PutMapping("/{productId}")
    public Product modifyProduct(@PathVariable("productId") Long productId,
                                 @RequestBody RequestProductForm requestProductForm) {
        log.info("modifyProduct()");

        return productService.modify(productId, requestProductForm);
    }
}
