package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name="Facture")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Facture implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFacture ;
	private float montantRemsie ;
	private float montantFacture;
	private Date dateCreationFacture ;
	private Date dateDerniereModification ;
	private boolean archivee ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	private Set<Reglement> reglements;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	private Set<DetailFacture> detailfacture;
	
	@ManyToOne
	Fournisseur fournisseur;

}
