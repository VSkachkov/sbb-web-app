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
    @Table(name = "ROLE", schema = "SBB_DB")
    public class Role implements Serializable {

        @Id
        @Column(name = "ROLE_ID", nullable = false)
        @GenericGenerator(name = "generator", strategy = "increment")
        @GeneratedValue(generator = "generator")
        private long roleId;

        @Basic
        @Column(name = "NAME")
        private String roleName;

    }

