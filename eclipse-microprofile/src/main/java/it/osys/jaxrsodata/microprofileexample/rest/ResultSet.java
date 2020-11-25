package it.osys.jaxrsodata.microprofileexample.rest;

import java.util.Collection;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Default output class
 * 
 * @author Domenico Briganti
 *
 * @param <T> Type of list
 */
public class ResultSet<T> {

	@JsonbProperty(value = "@odata.count")
	public long count;

	public Collection<T> value;

	@Override
	public String toString() {
		return "ResultSet [count=" + count + ", value=" + value + "]";
	}

}