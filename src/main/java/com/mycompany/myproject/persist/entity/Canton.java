package com.mycompany.myproject.persist.entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
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

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table (name = "cantons", schema = "SBB_DB")
public class Canton implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "canton_id")
	private Long cantonId;

	@Basic
	@Column(name = "canton_name")
	private String cantonName;




}
