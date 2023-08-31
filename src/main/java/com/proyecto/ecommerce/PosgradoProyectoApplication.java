package com.proyecto.ecommerce;

import com.proyecto.ecommerce.entity.Category;
import com.proyecto.ecommerce.entity.Product;
import com.proyecto.ecommerce.entity.Role;
import com.proyecto.ecommerce.repository.CategoryRepository;
import com.proyecto.ecommerce.repository.ProductRepository;
import com.proyecto.ecommerce.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PosgradoProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosgradoProyectoApplication.class, args);
	}
	/*
	@Bean
	public CommandLineRunner setData (
			CategoryRepository categoryRepository,
			ProductRepository productRepository,
			RoleRepository roleRepository
	)
{

		return args -> {
			Category category1 = new Category();
			category1.setName("travel");
			category1.setDescription("abc");

			Category category2 = new Category();
			category2.setName("vieje");
			category2.setDescription("def");

			categoryRepository.save(category1);
			categoryRepository.save(category2);

			Product product1 = new Product();
			product1.setName("producto A");
			product1.setDescription("descripcion 2");
			product1.setStock(100);
			product1.setImageUrl("http://image.png");
			product1.setPrice(20.23);
			product1.setActive(true);
			product1.setCategory(category2);
			productRepository.save(product1);

			Role role1 = new Role();
			role1.setName("admin");
			role1.setDescription("SOY ADMI");

			Role role2 = new Role();
			role2.setName("user");
			role2.setDescription("SOY USER");

			roleRepository.save(role1);
			roleRepository.save(role2);

		};*
	}*/

}
