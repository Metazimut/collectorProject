package sopra.formation.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sopra.formation.model.Message;

public interface IMessageRepository extends JpaRepository<Message, Long> {

}
