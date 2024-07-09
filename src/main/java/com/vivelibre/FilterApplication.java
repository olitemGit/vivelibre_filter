package com.vivelibre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vivelibre.filter.BookFilter;


@SpringBootApplication
public class FilterApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FilterApplication.class, args);
		BookFilter app = new BookFilter();
	    app.filter("", null);
	}

}
