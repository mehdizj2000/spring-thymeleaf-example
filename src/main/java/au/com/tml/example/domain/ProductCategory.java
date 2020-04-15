package au.com.tml.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String category;

}
