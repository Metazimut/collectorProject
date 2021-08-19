package sopra.formation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.formation.model.Categorie;
import sopra.formation.model.ParticipationEnchere;
import sopra.formation.model.Publication;
import sopra.formation.model.Utilisateur;
import sopra.formation.repository.IAdresseRepository;
import sopra.formation.repository.ICategorieRepository;
import sopra.formation.repository.ICompteRepository;
import sopra.formation.repository.IParticipationEnchereRepository;
import sopra.formation.repository.IPublicationRepository;

@SpringBootTest
class CollectorProjectBootApplicationTests {

	@Autowired
	private IPublicationRepository publicationRepo;
	@Autowired
	private ICompteRepository compteRepo;
	@Autowired
	private ICategorieRepository categorieRepo;
	@Autowired
	private IParticipationEnchereRepository participationEnchereRepo;


	@Test
	public void findAllByCategorie() {
		System.out.println("testFindAllByCategorie Début ###################");

		Categorie cat1 = new Categorie();
		cat1.setCategorieNom("Console");;
		cat1 = categorieRepo.save(cat1);

		Categorie cat2 = new Categorie();
		cat2.setCategorieNom("Carte");
		cat2 = categorieRepo.save(cat2);

		int sizeStart = publicationRepo.findAllByCategorie(cat1).size();

		Publication pub1 = new Publication();
		pub1.setNom("pub1");
		pub1.setCategorie(cat1);

		pub1 = publicationRepo.save(pub1);


		Publication pub2 = new Publication();
		pub2.setNom("pub2");
		pub2.setCategorie(cat2);

		pub2 = publicationRepo.save(pub2);


		int sizeEnd = publicationRepo.findAllByCategorie(cat1).size();

		assertEquals(1, sizeEnd - sizeStart);

		System.out.println("testFindAllByCategorie Fin ###################");
	}

	@Test
	public void findAllByPublicateur() {
		System.out.println("testFindAllByPublicateur Début ###################");

		Utilisateur ut1 = new Utilisateur();
		ut1.setNom("mat");
		ut1 = compteRepo.save(ut1);

		Utilisateur ut2 = new Utilisateur();
		ut2.setNom("aure");
		ut2 = compteRepo.save(ut2);

		int sizeStart = publicationRepo.findAllByPublicateur(ut1).size();

		Publication pub1 = new Publication();
		pub1.setNom("pub1");
		pub1.setPublicateur(ut1);

		pub1 = publicationRepo.save(pub1);


		Publication pub2 = new Publication();
		pub2.setNom("pub2");
		pub2.setPublicateur(ut2);

		pub2 = publicationRepo.save(pub2);


		int sizeEnd = publicationRepo.findAllByPublicateur(ut1).size();

		assertEquals(1, sizeEnd - sizeStart);

		System.out.println("testFindAllByPublicateur Fin ###################");
	}

	@Test
	public void findByEncheres() {
		System.out.println("testfindByEncheres Début ###################");
		Publication pub1 = new Publication();
		pub1.setNom("pubWithPart");
		pub1 = publicationRepo.save(pub1);
		
		ParticipationEnchere part1 = new ParticipationEnchere();
		part1.setPrixProposition(6L);;
		part1.setPublication(pub1);
		part1 = participationEnchereRepo.save(part1);



		Publication pub1Find = publicationRepo.findByEncheres(part1);

		assertEquals("pubWithPart", pub1Find.getNom());


		System.out.println("testfindByEncheres Fin ###################");
	}

}
