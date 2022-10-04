package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="DetailFacture")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetailFacture implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDetailFacture ;
	private Integer qteCommandee ;
	private float prixTotalDetail ;
	private Integer pourcentageRemise ;
	private float montantRemise ;
	@ManyToOne
	Facture facture;
	@ManyToOne
	Produit produit;
}
