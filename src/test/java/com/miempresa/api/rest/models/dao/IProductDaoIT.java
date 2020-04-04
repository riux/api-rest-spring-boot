package com.miempresa.api.rest.models.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import com.miempresa.api.rest.TestConfig;
import com.miempresa.api.rest.models.entity.Product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


/**
 * IProductDaoIT
 */

@TestConfig
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class IProductDaoIT {

  @Autowired
  private IProductDao productDao;

  @Autowired
  private TestEntityManager entityManager;


  @BeforeEach
  void before(){

  }

  @Test
  public void givenSetOfProducts_whenFindAll_thenReturnAllProducts(){
    Product product1 = new Product("Product 1", "Description product 1", new Date());
    Product product2 = new Product("Product 2", "Description product 2", new Date());
    Product product3 = new Product("Product 3", "Description product 3", new Date());

    entityManager.persist(product1);
    entityManager.persist(product2);
    entityManager.persist(product3);
    entityManager.flush();

    List<Product> allProducts = (List<Product>) productDao.findAll();

    assertThat(allProducts).hasSize(3)
    .extracting(Product::getName)
    .containsOnly(
      product1.getName(),
      product2.getName(),
      product3.getName()
    );
  }

  @Test
  public void whenFindAll_thenReturnNull(){
    List<Product> allProducts = (List<Product>) productDao.findAll();
    assertThat(allProducts).isEmpty();
  }
}
