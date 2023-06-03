package services;

import lombok.SneakyThrows;
import org.example.entity.Client;
import org.hibernate.Session;

import java.util.List;

public class ClientCrudService {

    @SneakyThrows
    public Client create(String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Client client = null;
        try {
            session.beginTransaction();
            client = new Client();
            client.setName(name);
            session.persist(client);
            session.getTransaction().commit();

            Client clientRead = session.createQuery("FROM Client c WHERE c.name = :name", Client.class)
                    .setParameter("name", name)
                    .uniqueResult();
            if (clientRead != null) {
                client = clientRead;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return client;
    }
@SneakyThrows
    public Client getById(long id)  {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        return client;
    }

    public void setName(long id, String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            client.setName(name);
            session.persist(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.remove(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Client> getAll(){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Client> clients = session.createQuery("from Client", Client.class).list();
        return clients;
    }


}