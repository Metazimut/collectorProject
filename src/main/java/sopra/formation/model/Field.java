package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;


@Entity
@DiscriminatorValue("Field")
public class Field {

	@Id
	@GeneratedValue
	private Long id;

	@Version
    private int version;
	
	@Column(name = "categorie", length = 100)
	private String categorie;

	@ManyToOne
	private String Auteur ;

	@OneToMany(mappedBy = "field")
	private List<Message> messages = new ArrayList<Message>();


	public Field() {
		super();
	}

	public Field(Long id, String categorie, String auteur, List<Message> messages) {
		super();
		this.id = id;
		this.categorie = categorie;
		Auteur = auteur;
		this.messages = messages;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public String getAuteur() {
		return Auteur;
	}


	public void setAuteur(String auteur) {
		Auteur = auteur;
	}


	public List<Message> getMessages() {
		return messages;
	}


	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}


}
