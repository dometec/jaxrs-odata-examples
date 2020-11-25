package it.osys.jaxrsodata.openlibertyexample.rest.converter;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import it.osys.jaxrsodata.openlibertyexample.entity.Author;
import it.osys.jaxrsodata.openlibertyexample.rest.dto.AuthorDto;

public class AuthorConverter {

	public Collection<AuthorDto> to(List<Author> list) {
		Collection<AuthorDto> out = new HashSet<>();
		list.forEach(a -> {
			AuthorDto dto = new AuthorDto();
			dto.id = a.getId();
			dto.firstname = a.getFirstname();
			dto.lastname = a.getLastname();
			dto.email = a.getEmail();
			dto.birtdate = a.getBirthdate();
			dto.added = a.getAdded();
			out.add(dto);
		});
		return out;
	}

}
