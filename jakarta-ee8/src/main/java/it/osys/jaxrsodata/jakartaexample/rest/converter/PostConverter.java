package it.osys.jaxrsodata.jakartaexample.rest.converter;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import it.osys.jaxrsodata.jakartaexample.entity.Post;
import it.osys.jaxrsodata.jakartaexample.rest.dto.PostDto;

public class PostConverter {

	public Collection<PostDto> to(List<Post> list) {
		Collection<PostDto> out = new HashSet<>();
		list.forEach(p -> {
			PostDto dto = new PostDto();
			dto.authorId = p.getAuthor().getId();
			dto.id = p.getId();
			dto.title = p.getTitle();
			dto.description = p.getDescription();
			dto.contect = p.getContent();
			dto.date = p.getDate();
			out.add(dto);
		});
		return out;
	}

}
