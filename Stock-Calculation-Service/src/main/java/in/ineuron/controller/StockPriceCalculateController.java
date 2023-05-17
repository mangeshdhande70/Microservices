package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.StockClient;

@RestController
@RequestMapping(value = "/stock")
public class StockPriceCalculateController {

	@Autowired
	private StockClient client;

	@GetMapping(value = "/calulate/{compnayName}/{quantity}")
	public ResponseEntity<?> calculate(@PathVariable String compnayName, @PathVariable Integer quantity) {

		ResponseEntity<?> responseEntity = null;
		Double totalPrice = null;

		System.out.println(compnayName);
		System.out.println(quantity);

		try {

			responseEntity = client.getStockPrice(compnayName);
			System.out.println(responseEntity);

			int statusCode = responseEntity.getStatusCode().value();

			if (statusCode == 200) {

				Double compnayStockPrice = (Double) responseEntity.getBody();

				totalPrice = compnayStockPrice * quantity;
				String response = "Total Cost :: " + totalPrice;
				responseEntity = new ResponseEntity<String>(response, HttpStatus.OK);

			}

		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("company not found", HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}

}
