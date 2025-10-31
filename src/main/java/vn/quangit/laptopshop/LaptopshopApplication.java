package vn.quangit.laptopshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LaptopshopApplication extends SpringBootServletInitializer {

	// Khi deploy WAR vào Tomcat, phương thức này sẽ được gọi
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LaptopshopApplication.class);
	}

	// Dùng khi chạy local
	public static void main(String[] args) {
		SpringApplication.run(LaptopshopApplication.class, args);
	}
}
