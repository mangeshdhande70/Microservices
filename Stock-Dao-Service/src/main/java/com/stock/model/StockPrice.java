package com.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STOCK_PRICE")
public class StockPrice {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STOCK_ID")
	private Integer stockId;
	
	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	@Column(name = "COMAPANY_PRICE")
	private Double companyPrice;

}
