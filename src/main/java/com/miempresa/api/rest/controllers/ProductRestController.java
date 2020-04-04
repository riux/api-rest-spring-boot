package com.miempresa.api.rest.controllers;

import java.util.List;

import com.miempresa.api.rest.models.entity.Product;
import com.miempresa.api.rest.services.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductRestController {

  @Autowired
  private IProductService productService;

  @GetMapping("/products")
  public List<Product> index(){
    return productService.getAllProducts();
  }

}
