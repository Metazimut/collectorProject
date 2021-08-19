package sopra.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	private String categorieNom;
	private String imgCat;
	
	public Categorie() {
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

	public String getCategorieNom() {
		return categorieNom;
	}

	public void setCategorieNom(String categorieNom) {
		this.categorieNom = categorieNom;
	}

	public String getImgCat() {
		return imgCat;
	}

	public void setImgCat(String imgCat) {
		this.imgCat = imgCat;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", version=" + version + ", categorieNom=" + categorieNom + ", imgCat=" + imgCat
				+ "]";
	}
	
}
