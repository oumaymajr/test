package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
@Table(name="Reglement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reglement implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idReglement ; 
	private float monatantPaye ;
	private float montantRestant ;
	private boolean payee ;
	private Date dateReglement ;
	@ManyToOne
	Facture facture;
	
}
