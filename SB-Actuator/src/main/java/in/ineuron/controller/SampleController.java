package in.ineuron.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class SampleController {

	
	@GetMapping(value = "/msg/{name}")
	public ResponseEntity<String> getMsg(@PathVariable String name){
		
		String msg = "";
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		int hour = localDateTime.getHour();
		
		if (hour < 12) {
			
			msg+="Good Morning "+name;
		}else if (hour < 16) {
			msg+="Good Afternoon "+name;
			
		}else if (hour < 20) {
			msg+="Good Evening "+name;
		}else {
			msg+="Good Night "+name;
		}
		
	
		return new ResponseEntity<>(msg , HttpStatus.OK);
		
	}
	
	
}
