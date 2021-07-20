package sopra.formation.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sopra.formation.model.Publication;

public interface IPublicationRepository extends JpaRepository<Publication, Long>{

}
