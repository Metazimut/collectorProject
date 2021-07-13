package sopra.formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "message")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	
	@Column(name = "messageTxt")
	private String messageTxt;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "creationDate")
	private Date dateCreation;
	
	@ManyToOne
	@JoinColumn(name = "envoyeur_id")
	private Utilisateur envoyeur;
	
	@ManyToOne
	@JoinColumn(name = "recepteur_id")
	private Utilisateur recepteur;

	public Message() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	

	
}
