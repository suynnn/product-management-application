package org.product.management.productmanagementapplication.application;

import org.product.management.productmanagementapplication.Infrastructure.ListProductRepository;
import org.product.management.productmanagementapplication.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class SimpleProductService {

    private ListProductRepository listProductRepository;

    public SimpleProductService(ListProductRepository listProductRepository) {
        this.listProductRepository = listProductRepository;
    }

    public Product add(Product product) {
        Product savedProduct = listProductRepository.add(product);

        return savedProduct;
    }
}
