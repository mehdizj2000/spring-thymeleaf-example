package au.com.tml.example.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CustomerDto {

	private Integer id;

	@NotEmpty
	@Size(min = 2, max = 10)
	private String firstName;

	@NotEmpty
	@Size(min = 2, max = 10)
	private String lastName;

	@NotEmpty
	private String phone;

	@NotEmpty
	@Email
	private String email;

}
