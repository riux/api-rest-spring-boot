package com.miempresa.api.rest.service;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import com.miempresa.api.rest.TestConfig;
import com.miempresa.api.rest.models.dao.IProductDao;
import com.miempresa.api.rest.models.entity.Product;
import com.miempresa.api.rest.services.IProductService;
import com.miempresa.api.rest.services.ProductServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties.Identityprovider.Verification;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

@TestConfig
public class ProductServiceImplTest {

  @TestConfiguration
  static class ProductServiceImplTestContextConfiguration {
    @Bean
    public IProductService productService() {
      return new ProductServiceImpl();
    }
  }

  @Autowired
  private IProductService productService;

  @MockBean
  private IProductDao productDao;

  @BeforeEach
  public void setUp() {
    Product product1 = new Product("Product 1", "Description product 1", new Date());
    product1.setId(1L);
    Product product2 = new Product("Product 2", "Description product 2", new Date());
    Product product3 = new Product("Product 3", "Description product 3", new Date());

    List<Product> allProducts = Arrays.asList(product1, product2, product3);

    Mockito.when(productDao.findAll()).thenReturn(allProducts);

  }

  @Test
  public void given3Products_whenGetAll_thenReturn3Records() {
    Product product1 = new Product("Product 1", "Description product 1", new Date());
    Product product2 = new Product("Product 2", "Description product 2", new Date());
    Product product3 = new Product("Product 3", "Description product 3", new Date());

    List<Product> allProducts = productService.getAllProducts();

    Mockito.verify(productDao, VerificationModeFactory.times(1))
      .findAll();
    Mockito.reset(productDao);

    assertThat(allProducts).hasSize(3).extracting(Product::getName)
      .contains(
        product1.getName(),
        product2.getName(),
        product3.getName()
      );

  }

}
