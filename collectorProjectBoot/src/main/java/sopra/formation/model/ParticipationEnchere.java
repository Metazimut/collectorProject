package sopra.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "participatienEnchere")
public class ParticipationEnchere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name = "prixProposition")
	private Long prixProposition;
	@Column(name = "placeNb")
	private int placeNb;
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name = "publication_id")
	private Publication publication;
	
	public ParticipationEnchere() {
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

	public Long getPrixProposition() {
		return prixProposition;
	}

	public void setPrixProposition(Long prixProposition) {
		this.prixProposition = prixProposition;
	}

	public int getPlaceNb() {
		return placeNb;
	}

	public void setPlaceNb(int placeNb) {
		this.placeNb = placeNb;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	@Override
	public String toString() {
		return "ParticipationEnchere [id=" + id + ", version=" + version + ", prixProposition=" + prixProposition
				+ ", placeNb=" + placeNb + ", publication=" + publication + "]";
	}
	
}
