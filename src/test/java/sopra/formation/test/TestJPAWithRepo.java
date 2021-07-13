package sopra.formation.test;

import java.text.ParseException;

import sopra.formation.Application;
import sopra.formation.model.Adresse;
import sopra.formation.repository.IAdresseRepository;
import sopra.formation.repository.IMessageRepository;


public class TestJPAWithRepo {

	public static void main(String[] args) throws ParseException {
		
		IMessageRepository MessageRepo = Application.getInstance().getMessageRepo();

		
	}

}
