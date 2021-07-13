package sopra.formation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.formation.repository.IAdresseRepository;
import sopra.formation.repository.IMessageRepository;
import sopra.formation.repository.jpa.AdresseRepositoryJpa;
import sopra.formation.repository.jpa.MessageRepositoryJpa;


public class Application {
	private static Application instance = null;

	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation-jpa");

	private final IMessageRepository MessageRepo = new MessageRepositoryJpa();


	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public IMessageRepository getMessageRepo() {
		return MessageRepo;
	}

	
	
}
