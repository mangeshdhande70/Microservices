package com.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.exception.StockNotFoundException;
import com.stock.model.StockPrice;
import com.stock.repo.IStockRepo;

@Service
public class StockPriceServiceImpl implements IStockPriceService{
	
	@Autowired
	private IStockRepo repo;

	@Override
	public Double findByCompanyName(String companyName) {
		StockPrice stockPrice = repo.findByCompanyName(companyName);
		
		if (stockPrice == null) {	
			throw new StockNotFoundException("Company Not Registered in Stock");
		}
		
		return stockPrice.getCompanyPrice();
	}

}
