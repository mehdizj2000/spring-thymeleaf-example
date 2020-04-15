package au.com.tml.example.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String courseName;
	private String courseSubtitle;
	private String courseDescription;

	@OneToOne
	@JoinColumn(name = "fk_author_id")
	private Author author;

	private BigDecimal price;

	@ManyToMany
	@JoinTable(name = "prod_prod_cat", joinColumns = {
			@JoinColumn(name = "prod_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "prod_cat_id", referencedColumnName = "id") })
	private List<ProductCategory> productCategories;

	private String imageUrl;

	public void addProductCategory(ProductCategory prodCat) {
		if (productCategories == null)
			productCategories = new ArrayList<ProductCategory>();
		productCategories.add(prodCat);
	}

	public void removeProductCategory(ProductCategory prodCat) {
		if (productCategories == null)
			productCategories = new ArrayList<ProductCategory>();
		productCategories.remove(prodCat);
	}

}
