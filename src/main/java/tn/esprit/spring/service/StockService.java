package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;
@Slf4j
@Service
public class StockService implements IStockService{
	@Autowired
	StockRepository stockRepository;
	@Override
	public List<Stock> retrieveAllStocks() {
		// TODO Auto-generated method stub
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		// TODO Auto-generated method stub
		log.info("Stock Added");
		return stockRepository.save(s);
	}

	@Override
	public void deleteStock(Long id) {
		// TODO Auto-generated method stub
		stockRepository.deleteById(id);
	}

	@Override
	public Stock updateStock(Stock s) {
		// TODO Auto-generated method stub
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long id) {
		// TODO Auto-generated method stub
		return stockRepository.findById(id).orElse(null);
	}
	@Scheduled(fixedRate = 60000)
	public void VerifyStock() {
		Stock s = stockRepository.findById((long) 3).orElse(null);
		if(s.getQte()>s.getQteMin()) {
			System.out.println("En stock");
		}else {
			System.out.println("hors Stock");
		}
		
	}
	@Scheduled(cron = "*/60 * * * * *")
	public void VerifyStock2() {
		Stock s = stockRepository.findById((long) 2).orElse(null);
		if(s.getQte()>s.getQteMin()) {
			System.out.println("En stock");
		}else {
			System.out.println("hors Stock");
		}
		
	}

}
