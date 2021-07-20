package sopra.formation.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sopra.formation.model.Field;

public interface IFieldRepository extends JpaRepository<Field, Long> {

}
