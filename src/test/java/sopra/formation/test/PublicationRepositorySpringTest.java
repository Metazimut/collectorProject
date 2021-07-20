package sopra.formation.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.Application;
import sopra.formation.model.Publication;
import sopra.formation.model.Utilisateur;
import sopra.formation.repository.ICompteRepository;
import sopra.formation.repository.IPublicationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class PublicationRepositorySpringTest {

	@Autowired
	private IPublicationRepository publicationRepo;
	
	@Autowired
	private ICompteRepository compteRepo;


	@Test
	public void findAll() {
		System.out.println("testFindAll Début ###################");

		int sizeStart = publicationRepo.findAll().size();
		
		Utilisateur ut1 = new Utilisateur();
		ut1.setNom("mat");
		ut1 = compteRepo.save(ut1);
		
		Publication pub1 = new Publication();
		pub1.setNom("pub1");
		pub1.setPublicateur(ut1);
		
		pub1 = publicationRepo.save(pub1);
		
		
		Utilisateur ut2 = new Utilisateur();
		ut2.setNom("aure");
		ut2 = compteRepo.save(ut2);

		Publication pub2 = new Publication();
		pub2.setNom("pub2");
		pub2.setPublicateur(ut2);

		pub2 = publicationRepo.save(pub2);

		
		int sizeEnd = publicationRepo.findAll().size();

		Assert.assertEquals(2, sizeEnd - sizeStart);

		System.out.println("testFindAll Fin ###################");
	}

}
