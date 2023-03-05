package com.tn.service.impl;

import com.tn.dto.ProductDto;
import com.tn.entity.Product;
import com.tn.repository.IProductRepository;
import com.tn.service.IProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private IProductRepository productRepo;

    private ModelMapper modelMapper;

    public ProductServiceImpl(IProductRepository productRepo,
                              ModelMapper modelMapper) {
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productRepo.findAll();
        List<ProductDto> productDtos = modelMapper.map(products, new TypeToken<List<ProductDto>>(){}.getType());
        return productDtos;
    }

    @Override
    public Product getProductById(Integer id) {
        Product product = productRepo.findById(id).get();
        return product;
    }


}
