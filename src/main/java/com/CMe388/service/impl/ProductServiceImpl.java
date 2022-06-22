package com.CMe388.service.impl;

import com.CMe388.dao.ProductMapper;
import com.CMe388.pojo.Product;
import com.CMe388.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private ProductMapper productMapper;
    @Autowired
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> findAllProduct() {
        return productMapper.findAllProduct();
    }
}
