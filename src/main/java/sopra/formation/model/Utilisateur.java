package sopra.formation.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("user")
public class Utilisateur extends Compte {
	
	@Column(name = "firstName")
	private MoyenPaiement moyenPaiement;
	
//	@OneToMany(mappedBy = "auteur")
//	private List<Field> fields = new ArrayList<Field>();
	
//	@OneToMany(mappedBy = "utilisateur")
//	private List<Commentaire> commentaires = new ArrayList<Commentaire>();
	
//	@OneToMany(mappedBy = "publicateur")
//	private List<Publication> publications = new ArrayList<Publication>();
	
//	@OneToMany(mappedBy = "utilisateur")
//	private List<ParticipationEnchere> encheres = new ArrayList<ParticipationEnchere>();
	
	@OneToMany(mappedBy = "envoyeur")
	private List<Message> envoi = new ArrayList<Message>();	
	
	@OneToMany(mappedBy = "recepteur")
	private List<Message> reçoit = new ArrayList<Message>();
	
	public Utilisateur() {
		super();
	}

	@Override
	public String toString() {
		return "Utilisateur [moyenPaiement=" + moyenPaiement + "]";
	}
	

}
