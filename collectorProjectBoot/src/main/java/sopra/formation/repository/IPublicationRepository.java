package sopra.formation.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Publication;

public interface IPublicationRepository extends JpaRepository<Publication, Long>{
	
	@Query("select p from Publication p where p.categorie.id = :id")
	List<Publication> findAllPublicationByCategorie(@Param("id") Long id);
	
	@Query("select p from Publication p where p.publicateur.id = :id")
	List<Publication> findAllPublicationByPublicateur(@Param("id") Long id);

}
