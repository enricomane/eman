package it.eman.dto.gnome;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrastlewarkDto implements Serializable {

	private String id;
	private String name;
	private String thumbnail;
	private Integer age;
	private BigDecimal weight;
	private BigDecimal height;
	private String hair_color;

	private List<String> friends = new ArrayList();
	private List<String> professions = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public String getHair_color() {
		return hair_color;
	}

	public void setHair_color(String hair_color) {
		this.hair_color = hair_color;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public List<String> getProfessions() {
		return professions;
	}

	public void setProfessions(List<String> professions) {
		this.professions = professions;
	}

}
