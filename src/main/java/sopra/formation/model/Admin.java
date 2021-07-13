package sopra.formation.model;



import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {
	
	
	public Admin() {
		super();
	}


}
