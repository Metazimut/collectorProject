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

import sopra.formation.model.Publication;
import sopra.formation.model.Utilisateur;
import sopra.formation.model.Views;
import sopra.formation.repository.ICompteRepository;
import sopra.formation.repository.IPublicationRepository;


@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurRestController {
	@Autowired
	private ICompteRepository utilisateurRepo;
	
	@Autowired
	private IPublicationRepository publicationRepo;

	@GetMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> findAll() {
		return utilisateurRepo.findAllUtilisateur();
	}
	

	@GetMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur find(@PathVariable Long id) {

		Optional<Utilisateur> optUtilisateur = utilisateurRepo.findUtilisateurById(id);
	
		if (optUtilisateur.isPresent()) {
			return optUtilisateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/{id}/all-publications")
	@JsonView(Views.ViewUtilisateurPublications.class)
	public List<Publication> findAllPublication(@PathVariable Long id) {
		return publicationRepo.findAllPublicationByPublicateur(id);
	}
	

	@PostMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		utilisateur = utilisateurRepo.save(utilisateur);

		return utilisateur;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable Long id) {
		if (!utilisateurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		utilisateur = utilisateurRepo.save(utilisateur);

		return utilisateur;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!utilisateurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		utilisateurRepo.deleteById(id);
	}
}
