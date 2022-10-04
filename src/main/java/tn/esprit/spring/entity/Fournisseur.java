package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="Fournisseur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fournisseur implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idFournisseur;
	private String codeFournisseur;
	private String libelleFournisseur;
	@Enumerated(EnumType.STRING)
	private CategorieFournisseur categorieFournisseur;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="fournisseur")
	private Set<Facture> factures;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 private DetailFournisseur detailfournisseur;
	 
	 @ManyToMany(cascade = CascadeType.ALL)
	 private Set<SecteurActivite> secteursactivites;
}

