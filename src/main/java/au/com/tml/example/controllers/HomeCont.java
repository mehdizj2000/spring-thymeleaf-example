package au.com.tml.example.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import au.com.tml.example.dto.CustomerDto;
import au.com.tml.example.services.ProductService;

@Controller
public class HomeCont {

	private ProductService productService;

	@GetMapping("/checkout")
	public String showCheckout(@ModelAttribute("customerInfo") CustomerDto customerInfo) {
		return "checkoutForm";
	}

	@PostMapping("/checkout")
	public String doCheckout(@Valid @ModelAttribute("customerInfo") CustomerDto customerInfo, BindingResult result) {

		if (result.hasErrors()) {
			return "checkoutForm";
		}

		return "checkoutResult";
	}

	@GetMapping({ "/", "/index" })
	public String index(Model model) {
		model.addAttribute("products", productService.listProducts());
		return "index";
	}

	@GetMapping("/product")
	public String listProducts() {
		return "redirect:/index";
	}

	@GetMapping("/product/{id}")
	public String showProductDetails(@PathVariable Integer id, Model model) {

		model.addAttribute("product", productService.getProduct(id));

		return "product";
	}

	public ProductService getProductService() {
		return productService;
	}

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
