package sopra.formation.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sopra.formation.model.MessageField;

public interface IMessageFieldRepository extends JpaRepository<MessageField, Long>{

}
