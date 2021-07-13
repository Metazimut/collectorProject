package sopra.formation.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "MessageField")
public class MessageField {
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
	private String field ;


	public MessageField() {
		super();
	}

	public MessageField(Long id, String message, String field) {
		super();
		this.id = id;
		this.message = message;
		Field = field;
	}
	
	
}
