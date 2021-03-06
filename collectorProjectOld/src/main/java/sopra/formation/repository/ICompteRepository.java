package sopra.formation.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Commentaire;
import sopra.formation.model.Compte;
import sopra.formation.model.Utilisateur;
import sopra.formation.model.ParticipationEnchere;
import sopra.formation.model.Publication;
import sopra.formation.model.Admin;


public interface ICompteRepository extends JpaRepository<Compte, Long> {
	
	@Query("select s from Admin s")
	List<Admin> findAllAdmin(); // @Query

	@Query("select f from Utilisateur f")
	List<Utilisateur> findAllUtilisateur(); // @Query
	
	@Query("select s from Admin s where s.id = :id")
	Optional<Admin> findAdminById(@Param("id") Long id);
	
	@Query("select f from Utilisateur f where f.id = :id")
	Optional<Utilisateur> findUtilisateurById(@Param("id") Long id);
	
	Utilisateur findByEncheres(ParticipationEnchere enchere);
	Utilisateur findByPublications(Publication publication);
	Utilisateur findByCommentaires(Commentaire commentaire);
	
	@Query("select c from Compte c join Adresse a where a.ville = :ville and a.pays = :pays")
	List<Compte> findAllByVille(@Param("ville") String ville, @Param("pays") String pays);
	
	@Query("select c from Compte c join Adresse a where a.codePostal = :codePostal and a.pays = :pays")
	List<Compte> findAllByCodePostal(@Param("codePostal") String codePostal, @Param("pays") String pays);
}
