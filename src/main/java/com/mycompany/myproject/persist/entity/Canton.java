package com.mycompany.myproject.persist.entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



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
