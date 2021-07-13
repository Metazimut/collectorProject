package sopra.formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Version;

@Entity
@DiscriminatorValue("Commentaire")
public class Commentaire {
	@Id
	@GeneratedValue
	private Long id;

	@Version
    private int version;
	
	@Column(name = "message")
	private String message;
	
	@Temporal
	private Date dateCreation;
	
	@ManyToOne
	private String Utilisateur ;
	
	@ManyToOne
	private String Publication ;
}
