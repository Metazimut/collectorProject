package sopra.formation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.formation.repository.ICategorieRepository;
import sopra.formation.repository.IParticipationEnchereRepository;
import sopra.formation.repository.IPublicationRepository;
import sopra.formation.repository.jpa.CategorieRepositoryJpa;
import sopra.formation.repository.jpa.ParticipationEnchereRepositoryJpa;
import sopra.formation.repository.jpa.PublicationRepositoryJpa;


public class Application {
	private static Application instance = null;

	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation-jpa");
	private final ICategorieRepository categorieRepo = new CategorieRepositoryJpa();
	private final IParticipationEnchereRepository participationEnchereRepo = new ParticipationEnchereRepositoryJpa();
	private final IPublicationRepository publicationRepo = new PublicationRepositoryJpa();
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

	public ICategorieRepository getCategorieRepo() {
		return categorieRepo;
	}

	public IParticipationEnchereRepository getParticipationEnchereRepo() {
		return participationEnchereRepo;
	}

	public IPublicationRepository getPublicationRepo() {
		return publicationRepo;
	}
	

}
