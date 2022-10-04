package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.spring.entity.CategorieProduit;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.CategorieProduitService;
import tn.esprit.spring.service.ProduitService;
import tn.esprit.spring.service.StockService;
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy
public class Tp1SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp1SpringBootApplication.class, args);
	}

}
