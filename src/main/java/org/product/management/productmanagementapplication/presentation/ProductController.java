package org.product.management.productmanagementapplication.presentation;

import org.product.management.productmanagementapplication.application.SimpleProductService;
import org.product.management.productmanagementapplication.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private SimpleProductService simpleProductService;

    @Autowired
    public ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }

    // @RequestBody : 클라이언트가 요청한 HTTP 요청 본문(body)을 자바 객체로 변환해주는 역할
    // 스프링이 자동으로 JSON과 같은 포맷을 Product 객체로 변환
    // 클라이언트가 보내는 JSON의 필드명과 Product 클래스의 필드명이 같아야 제대로 매핑이 됨
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductDto createProduct(@RequestBody ProductDto productDto) {

        return simpleProductService.add(productDto);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ProductDto findProductById(@PathVariable("id") Long id) {

        return simpleProductService.findById(id);
    }

//    @RequestMapping(value = "/products", method = RequestMethod.GET)
//    public List<ProductDto> findAllProduct() {
//
//        return simpleProductService.findAll();
//    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductDto> findProducts(
            @RequestParam(required = false, name = "name") String name
    ) {
        if (null == name) {
            return simpleProductService.findAll();
        }

        return simpleProductService.findByNameContaining(name);
    }
}
