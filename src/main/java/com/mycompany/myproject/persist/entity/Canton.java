package com.mycompany.myproject.persist.entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;




@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table (name = "cantons", schema = "SBB_DB")
public class Canton implements Serializable {

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "canton_id")
	private Long cantonId;

	@Basic
	@Column(name = "canton_name")
	private String cantonName;




}
