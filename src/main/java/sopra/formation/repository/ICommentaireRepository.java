package sopra.formation.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sopra.formation.model.Commentaire;

public interface ICommentaireRepository extends JpaRepository<Commentaire, Long> {

}
