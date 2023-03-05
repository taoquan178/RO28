package com.tn.service;

import com.tn.dto.ProductDto;
import com.tn.entity.Product;

import java.util.List;

public interface IProductService {

    List<ProductDto> getAll();

    Product getProductById(Integer id);
}
