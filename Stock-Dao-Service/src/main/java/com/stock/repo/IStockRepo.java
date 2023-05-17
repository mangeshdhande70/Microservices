package com.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.model.StockPrice;

public interface IStockRepo extends JpaRepository<StockPrice, Integer> {
	
	public StockPrice findByCompanyName(String companyName);

}
