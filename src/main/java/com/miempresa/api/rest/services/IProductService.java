package com.miempresa.api.rest.services;

import java.util.List;

import com.miempresa.api.rest.models.entity.Product;

public interface IProductService {

  public List<Product> getAllProducts();
}
