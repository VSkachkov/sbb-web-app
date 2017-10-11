package com.mycompany.myproject.persist.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


//@Entity
//@Table(name = "canton")
//public class Canton {
//
//	@Id
//	@GenericGenerator(name = "generator", strategy = "increment")
//	@GeneratedValue(generator = "generator")
//	private Long id;
//
//	@Column(name = "canton_name", nullable = false)
//	private String canton_name;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return canton_name;
//	}
//
//	public void setName(String name) {
//		this.canton_name = name;
//	}
//
//}

@Entity
@Table (name = "cantons")
public class Canton {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long canton_id;

	@Column
	private String canton_name;


//	@OneToMany(mappedBy = "cantonWithStations")
//	private List<Station> stations;



	public Long getId() {
		return canton_id;
	}

	public void setId(Long id) {
		this.canton_id = id;
	}

	public String getCantonName() {
		return canton_name;
	}

	public void setCantonName(String cantonName) {
		this.canton_name = cantonName;
	}

//	@OneToMany(mappedBy = "canton")
//	@JoinColumn (name = "cantonOwner_id", nullable = false)
//	public List<Station> getStations() {
//		return stations;
//	}

}
