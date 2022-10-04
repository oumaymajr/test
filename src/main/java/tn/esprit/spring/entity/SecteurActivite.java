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
@Table(name="SecteurActivite")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SecteurActivite implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idSecteurActivite;
	private String codeSecteurActivite  ;
	private String libelleSecteurActivite;
	@ManyToMany(cascade = CascadeType.ALL)
	 private Set<Fournisseur> fournisseurs;
}
