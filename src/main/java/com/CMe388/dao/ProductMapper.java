package com.CMe388.dao;

import com.CMe388.pojo.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> findAllProduct();
}