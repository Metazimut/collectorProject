package sopra.formation.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "MessageField")
public class MessageField {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
    private int version;
	
	@Column(name = "message")
	private String message;
	
	@Column
	private LocalDate dateCreation;

	@ManyToOne
	@JoinColumn(name = "field_id")
	private Field field ;


	public MessageField() {
		super();
	}

	public MessageField(Long id, String message, Field field) {
		super();
		this.id = id;
		this.message = message;
		this.field = field;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "MessageField [id=" + id + ", version=" + version + ", message=" + message + ", dateCreation="
				+ dateCreation + ", field=" + field + "]";
	}
	
	
}
