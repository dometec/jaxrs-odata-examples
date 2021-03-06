package it.osys.jaxrsodata.quarkusexample.rest.dto;

import java.time.LocalDate;

public class PostDto {

	public Integer id;
	public Integer authorId;
	public String title;
	public String description;
	public String contect;
	public LocalDate date;

	@Override
	public String toString() {
		return "PostDto [id=" + id + ", title=" + title + ", description=" + description + ", contect=" + contect + ", date=" + date + "]";
	}

}
