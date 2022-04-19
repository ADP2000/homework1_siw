package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private int durata;
	
	private LocalDate dataInizio;
	
	/* La politica di fetch adottata in questo caso è di tipo Eager in quanto per ciascun corso può essere utile avere informazioni anche sul 
	   docente che tiene quel corso */
	@ManyToOne
	private Docente docente;
	
	/* La politica di fetch adottata in questo caso è di tipo Lazy Load in quanto per ciascun corso non si ha la necessità di caricare le informazioni
	   riguardanti gli allievi iscritti a quel corso*/
	@ManyToMany
	private List<Allievo> allievi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}
}
