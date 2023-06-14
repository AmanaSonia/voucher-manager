package com.bracit.vouchermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class VoucherManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoucherManagerApplication.class, args);
	}

}
