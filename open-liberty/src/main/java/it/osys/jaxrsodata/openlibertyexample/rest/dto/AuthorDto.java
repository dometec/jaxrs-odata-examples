package it.osys.jaxrsodata.openlibertyexample.rest.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AuthorDto {

	public Integer id;
	public String firstname;
	public String lastname;
	public String email;
	public LocalDate birtdate;
	public LocalDateTime added;

	@Override
	public String toString() {
		return "AuthorDto [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", birtdate=" + birtdate
				+ ", added=" + added + "]";
	}

}
