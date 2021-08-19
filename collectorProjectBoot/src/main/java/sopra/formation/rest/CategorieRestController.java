package sopra.formation.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Categorie;
import sopra.formation.model.Publication;
import sopra.formation.model.Views;
import sopra.formation.repository.ICategorieRepository;
import sopra.formation.repository.IPublicationRepository;

@RestController
@RequestMapping("/categorie")
@CrossOrigin("*")
public class CategorieRestController {

	@Autowired
	private ICategorieRepository categorieRepo;
	
	@Autowired
	private IPublicationRepository publicationRepo;

	@GetMapping("")
	@JsonView(Views.ViewCategorie.class)
	public List<Categorie> findAll() {
		return categorieRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewCategorie.class)
	public Categorie find(@PathVariable Long id) {

		Optional<Categorie> optCategorie = categorieRepo.findById(id);

		if (optCategorie.isPresent()) {
			return (Categorie) optCategorie.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@GetMapping("/{id}/all-publications")
	@JsonView(Views.ViewCategoriePublications.class)
	public List<Publication> findAllPublication(@PathVariable Long id) {
		return publicationRepo.findAllPublicationByCategorie(id);
	}

	@PostMapping("")
	public Categorie create(@RequestBody Categorie categorie) {
		categorie = categorieRepo.save(categorie);

		return categorie;
	}

	@PutMapping("/{id}")
	public Categorie update(@RequestBody Categorie categorie, @PathVariable Long id) {
		if (!categorieRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		categorie = categorieRepo.save(categorie);

		return categorie;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!categorieRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		categorieRepo.deleteById(id);
	}
}
