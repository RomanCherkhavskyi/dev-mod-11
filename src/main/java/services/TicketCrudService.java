package services;


import lombok.SneakyThrows;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;

public class TicketCrudService {

    public List<Ticket> getAll(){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Ticket> tickets = session.createQuery("from Ticket", Ticket.class).list();
        return tickets;
    }

    @SneakyThrows
    public Ticket getById(int id)  {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Ticket ticket = session.get(Ticket.class, id);
        return ticket;
    }

    public void deleteById(int id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            session.remove(ticket);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public Ticket create(Timestamp createdAt, Client client, Planet fromPlanetId, Planet toPlanetId){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Ticket ticket = new Ticket();
        try {
            session.beginTransaction();

            ticket.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            ticket.setClient(client);
            ticket.setFromPlanetId(fromPlanetId);
            ticket.setFromPlanetId(toPlanetId);

            session.persist(ticket);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ticket;
    }

    public void create(Ticket ticket) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.persist(ticket);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }



}
