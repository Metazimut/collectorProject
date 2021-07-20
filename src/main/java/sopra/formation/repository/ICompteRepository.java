package sopra.formation.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sopra.formation.model.Compte;

public interface ICompteRepository extends JpaRepository<Compte, Long> {

}
