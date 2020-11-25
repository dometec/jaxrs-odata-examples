package it.osys.jaxrsodata.microprofileexample.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "authors", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "first_name", length = 50, nullable = false)
	private String firstname;

	@Column(name = "last_name", length = 50, nullable = false)
	private String lastname;

	@Column(length = 100, nullable = false)
	private String email;

	@Column(nullable = false)
	private LocalDate birthdate;

	@Column(nullable = false)
	private LocalDateTime added;

	@OneToMany(mappedBy = "author")
	private Set<Post> posts;

	public Author() {
		posts = new HashSet<>();
	}

	public Integer getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public LocalDateTime getAdded() {
		return added;
	}

	public void setAdded(LocalDateTime added) {
		this.added = added;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", birthdate=" + birthdate
				+ ", added=" + added + "]";
	}

}
