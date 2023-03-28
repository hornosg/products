package com.hornosg.products;

import com.hornosg.shared.infrastructure.SpringBootControllerExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Import(SpringBootControllerExceptionHandler.class)
@EnableAsync
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

	@Bean
	public ThreadPoolExecutor threadPoolExecutor() {
		int corePoolSize = 10;
		int maxPoolSize = 20;
		int queueCapacity = 100;
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
				corePoolSize, maxPoolSize, 60L, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(queueCapacity));

		return executor;
	}
}
