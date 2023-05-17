package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.HelloClient;

@RestController
public class ServiceController {
	
	@Autowired
	private HelloClient client;
	
	@GetMapping(value = "/hi/{name}")
	public String hiMsg(@PathVariable String name) {
		
		
		System.out.println("Implementation class name of Helloclinet is :: "+client.getClass().getName());
		
		String msg = "Hii "+name+", How are you?";
		
		
		String helloService = client.invokedHelloService("Dhoni");
		
		
		return msg+"\n------> Getting response from Hello Service ::--->"+helloService;	
	}

}
