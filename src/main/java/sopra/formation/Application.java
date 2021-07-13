package sopra.formation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.formation.repository.ICategorieRepository;
import sopra.formation.repository.IParticipationEnchereRepository;
import sopra.formation.repository.IPublicationRepository;
import sopra.formation.repository.jpa.CategorieRepositoryJpa;
import sopra.formation.repository.jpa.ParticipationEnchereRepositoryJpa;
import sopra.formation.repository.jpa.PublicationRepositoryJpa;
import sopra.formation.repository.IAdresseRepository;
import sopra.formation.repository.ICompteRepository;
import sopra.formation.repository.IMessageRepository;
import sopra.formation.repository.jpa.AdresseRepositoryJpa;
import sopra.formation.repository.jpa.CompteRepositoryJpa;
import sopra.formation.repository.jpa.MessageRepositoryJpa;


public class Application {
	private static Application instance = null;

	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation-jpa");
	private final ICategorieRepository categorieRepo = new CategorieRepositoryJpa();
	private final IParticipationEnchereRepository participationEnchereRepo = new ParticipationEnchereRepositoryJpa();
	private final IPublicationRepository publicationRepo = new PublicationRepositoryJpa();
	private final IMessageRepository MessageRepo = new MessageRepositoryJpa();
	private final ICompteRepository CompteRepo = new CompteRepositoryJpa();
	private final IAdresseRepository AdresseRepo = new AdresseRepositoryJpa();

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
	

	public IMessageRepository getMessageRepo() {
		return MessageRepo;
	}

	public ICompteRepository getCompteRepo() {
		return CompteRepo;
	}

	public IAdresseRepository getAdresseRepo() {
		return AdresseRepo;
	}

	
	
}
