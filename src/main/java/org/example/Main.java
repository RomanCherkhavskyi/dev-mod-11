package org.example;

import lombok.SneakyThrows;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


public class Main {
    @SneakyThrows
    public static void main(String[] args) {

//make migration for create and populate DB
        new FlywayMigration().flywayMigration();

//open hibernate session
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

//get all data from table ticket
//        System.out.println(new TicketCrudService().getAll());
//get ticket info by id
//        System.out.println(new TicketCrudService().getById(2));

        Client client = new ClientCrudService().create("Ivar");

        Planet fromPlanet = new Planet();
        fromPlanet.setPlanetId("E15");
        fromPlanet.setName("Eragon");

        Planet toPlanet = new Planet();
        toPlanet.setPlanetId("V12");
        toPlanet.setName("Venom");

        Ticket ticket = new Ticket();

        ticket.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        ticket.setFromPlanetId(fromPlanet);
        ticket.setToPlanetId(toPlanet);
        ticket.setClient(client);

        System.out.println("ticket = " + ticket);





//get client by id
//        System.out.println("Client name is: " + new ClientCrudService().getById(4));
////create new client
//        System.out.println("Created new client: " + new ClientCrudService().create("Maks"));
////change client name by id
//        new ClientCrudService().setName(4, "Victor");
////delete client by id
//        new ClientCrudService().deleteById(6);

//get planet by id
//        System.out.println("Planet name is: " + new PlanetCrudService().getById("M16"));
////create new planet
//        System.out.println("Created new planet: " + new PlanetCrudService().create("V12","Vavilon"));
////change planet name by id
//        new PlanetCrudService().setName("V12","Victory");
////delete planet by id
//        new PlanetCrudService().deleteById("V12");


//get ticket info by id
//        System.out.println("Ticket data is: " + new TicketCrudService().getById(2));


//close hibernate session
        session.close();
//disconnect DB
        HibernateUtil.getInstance().close();
    }
}