package com.mycompany.myproject.persist.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "canton")
public class Canton {

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	private Long id;

	@Column(name = "canton_name", nullable = false)
	private String canton_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return canton_name;
	}

	public void setName(String name) {
		this.canton_name = name;
	}

}
