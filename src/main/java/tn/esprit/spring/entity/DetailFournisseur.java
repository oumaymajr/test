package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="DetailFournisseur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetailFournisseur implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDetailFournisseur ;
	private Date dateDebutCollaboration;
	private String adresse;
	private String matricule;
	@OneToOne(cascade = CascadeType.ALL)
	private Fournisseur fournisseur;
}
