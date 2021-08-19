package sopra.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "publication")
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name = "nom")
	private String nom;
	@Column(name = "description")
	private String description;
	@Column(name = "img")
	private String img;
	@Column(name = "prixDepart")
	private Long prixDepart;
	@Column(name = "prixActuel")
	private Long prixActuel;
	@Column(name = "duree")
	@Temporal(TemporalType.TIMESTAMP)
	private Date duree;
	@ManyToOne
	@JoinColumn(name = "publicateur_id")
	private Utilisateur publicateur;
	@ManyToOne
	@JoinColumn(name = "categorie_id")
	private Categorie categorie;
	@OneToMany(mappedBy = "publication")
	private List<ParticipationEnchere> encheres = new ArrayList<ParticipationEnchere>();
	@OneToMany(mappedBy = "publication")
	private List<Commentaire> commentaires = new ArrayList<Commentaire>();
	
	public Publication() {
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Long getPrixDepart() {
		return prixDepart;
	}

	public void setPrixDepart(Long prixDepart) {
		this.prixDepart = prixDepart;
	}

	public Long getPrixActuel() {
		return prixActuel;
	}

	public void setPrixActuel(Long prixActuel) {
		this.prixActuel = prixActuel;
	}

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}

	public Utilisateur getPublicateur() {
		return publicateur;
	}

	public void setPublicateur(Utilisateur publicateur) {
		this.publicateur = publicateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<ParticipationEnchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<ParticipationEnchere> encheres) {
		this.encheres = encheres;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	@Override
	public String toString() {
		return "Publication [id=" + id + ", version=" + version + ", nom=" + nom + ", description=" + description
				+ ", img=" + img + ", prixDepart=" + prixDepart + ", prixActuel=" + prixActuel + ", duree=" + duree
				+ ", categorie=" + categorie + ", encheres=" + encheres + "]";
	}
	
}
