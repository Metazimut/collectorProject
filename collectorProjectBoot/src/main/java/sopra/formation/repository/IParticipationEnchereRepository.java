package sopra.formation.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.ParticipationEnchere;

public interface IParticipationEnchereRepository extends JpaRepository<ParticipationEnchere, Long> {
	@Query("select e from ParticipationEnchere e where e.publication.id = :publicationId and e.utilisateur.id = :utilisateurId")
	List<ParticipationEnchere> findAllEncheresByPublicationAndUtilisateur(@Param("publicationId") Long publicationId, @Param("utilisateurId") Long utilisateurId);
}