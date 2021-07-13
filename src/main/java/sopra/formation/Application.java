package sopra.formation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.formation.repository.IAdresseRepository;
import sopra.formation.repository.jpa.AdresseRepositoryJpa;


public class Application {
	private static Application instance = null;

	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation-jpa");

	//private final IEvaluationRepository evaluationRepo = new EvaluationRepositoryJpa();


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

}
