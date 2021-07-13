package sopra.formation.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
@DiscriminatorValue("Message")
public class Message {
	@Id
	@GeneratedValue
	private Long id;

	@Version
    private int version;
	
	@Column(name = "message")
	private String message;
	
	@Column
	private LocalDate dateCreation;

	@ManyToOne
	private String Field ;


	public Message() {
		super();
	}

	public Message(Long id, String message, String field) {
		super();
		this.id = id;
		this.message = message;
		Field = field;
	}
	
	
}
