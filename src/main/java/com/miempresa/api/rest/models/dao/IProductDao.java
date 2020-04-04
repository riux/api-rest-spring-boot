package com.miempresa.api.rest.models.dao;

import com.miempresa.api.rest.models.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDao extends JpaRepository<Product, Long>{

}
