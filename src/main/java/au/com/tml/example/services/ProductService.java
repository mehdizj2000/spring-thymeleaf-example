package au.com.tml.example.services;

import java.util.List;

import au.com.tml.example.domain.Product;

public interface ProductService {

	Product getProduct(Integer id);

	List<Product> listProducts();

}
