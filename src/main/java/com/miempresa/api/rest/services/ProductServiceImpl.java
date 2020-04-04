package com.miempresa.api.rest.services;

import java.util.List;

import com.miempresa.api.rest.models.dao.IProductDao;
import com.miempresa.api.rest.models.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

  @Autowired
  private IProductDao productDao;

  @Override
  public List<Product> getAllProducts() {
    return productDao.findAll();
  }

}
