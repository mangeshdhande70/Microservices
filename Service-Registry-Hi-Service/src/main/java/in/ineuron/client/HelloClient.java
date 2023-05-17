package in.ineuron.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Hello-Service")
public interface HelloClient {
	
	@GetMapping(value = "/hello/{name}")
	public String invokedHelloService(@PathVariable String name);

}
