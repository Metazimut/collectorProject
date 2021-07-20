package sopra.formation.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Commentaire;
import sopra.formation.model.Compte;
import sopra.formation.model.ParticipationEnchere;
import sopra.formation.model.Publication;
import sopra.formation.model.Utilisateur;

public interface ICompteRepository extends JpaRepository<Compte, Long> {
	Utilisateur findByEncheres(ParticipationEnchere enchere);
	Utilisateur findByPublications(Publication publication);
	Utilisateur findByCommentaires(Commentaire commentaire);
}
