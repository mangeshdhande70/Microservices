package in.ineuron.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ineuron.service.StockService;

@Controller
public class StockUIController {
	
	@Autowired
	private StockService service;
	
	@GetMapping(value = "/")
	public String loadPage(Model model) {
		
//		StockDto dto = new StockDto(); // for this refer MVC
//		model.addAttribute("dto" , dto);
		
		return "index";
	}
	
	
	@GetMapping(value = "/getTotalCost")
	public String getTotalCost(HttpServletRequest request, Model model) {
		
		String companyName = request.getParameter("companyName");
		String quantity = request.getParameter("quantity");
		String repsonse = service.getTotalStockPrice(companyName,Integer.parseInt(quantity));
		
		model.addAttribute("msg" , repsonse);
		
		return "index";
	}

}
