package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Stock;

public interface IStockService {
	List<Stock> retrieveAllStocks();

	Stock addStock (Stock s);

	void deleteStock (Long id);

	Stock updateStock (Stock s);

	Stock retrieveStock (Long id);
}
