package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name="CategorieProduit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategorieProduit implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorieProduit ;
	private String codeProduit ;
	private String libelleCategorieProduit ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="categorieproduit")
	private Set<Produit> produits;
}
