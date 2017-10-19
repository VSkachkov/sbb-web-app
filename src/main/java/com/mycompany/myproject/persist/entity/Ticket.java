package com.mycompany.myproject.persist.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Tickets", schema = "SBB_DB")
public class Ticket {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column (name = "ticket_id")
    private Long ticketId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
