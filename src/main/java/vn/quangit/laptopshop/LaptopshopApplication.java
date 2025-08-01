// src/main/java/vn/quangit/laptopshop/LaptopshopApplication.java
package vn.quangit.laptopshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// XÓA CÁC IMPORT NÀY
// import org.springframework.boot.builder.SpringApplicationBuilder;
// import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class LaptopshopApplication { // KHÔNG KẾ THỪA GÌ CẢ

	public static void main(String[] args) {
		System.out.println("anh yêu em nhiều lắm");
		SpringApplication.run(LaptopshopApplication.class, args);
	}

	// XÓA PHƯƠNG THỨC NÀY
	// @Override
	// protected SpringApplicationBuilder configure(SpringApplicationBuilder
	// application) {
	// return application.sources(LaptopshopApplication.class);
	// }
}