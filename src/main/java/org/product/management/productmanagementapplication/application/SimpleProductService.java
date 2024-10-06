package org.product.management.productmanagementapplication.application;

import org.modelmapper.ModelMapper;
import org.product.management.productmanagementapplication.Infrastructure.ListProductRepository;
import org.product.management.productmanagementapplication.domain.Product;
import org.product.management.productmanagementapplication.presentation.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ProductDto findById(Long id) {
        Product product = listProductRepository.findById(id);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);

        return productDto;
    }

    public List<ProductDto> findAll() {
        List<Product> products = listProductRepository.findAll();

        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();

        return productDtos;
    }

    public List<ProductDto> findByNameContaining(String name) {
        List<Product> products = listProductRepository.findByNameContaining(name);

        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();

        return productDtos;
    }

    public ProductDto update(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);

        Product updateProduct = listProductRepository.update(product);

        ProductDto updateProductDto = modelMapper.map(updateProduct, ProductDto.class);

        return updateProductDto;
    }

    public void delete(Long id) {
        listProductRepository.delete(id);
    }
}
