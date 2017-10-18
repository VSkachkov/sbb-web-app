package com.mycompany.myproject.service.dao.impl;

import com.mycompany.myproject.persist.entity.Ticket;
import com.mycompany.myproject.service.dao.api.TicketDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class TicketDaoImp implements TicketDao {


    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Ticket> getAllTickets() {
        return em.createQuery("FROM Ticket")
                .getResultList();
    }

    @Override
    public void addNewTicket(Ticket ticket) {

    }
}
