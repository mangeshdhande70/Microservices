package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ServiceRegistryHiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryHiServiceApplication.class, args);
	}

}
