package org.product.management.productmanagementapplication.application;

import org.modelmapper.ModelMapper;
import org.product.management.productmanagementapplication.Infrastructure.ListProductRepository;
import org.product.management.productmanagementapplication.domain.Product;
import org.product.management.productmanagementapplication.presentation.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class SimpleProductService {

    private ListProductRepository listProductRepository;
    private ModelMapper modelMapper;

    public SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper) {
        this.listProductRepository = listProductRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDto add(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);

        Product savedProduct = listProductRepository.add(product);

        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

        return savedProductDto;
    }
}
