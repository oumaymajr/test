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
@Table(name="Operateur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Operateur implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOperateur ;
	private String nom  ;
	private String prenom;
	private String password ;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Facture> factures;
}
