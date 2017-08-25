package run;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class Facade {

    private EntityManagerFactory emf;
    EntityManager em;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createCustomer(Customer c) {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    public Customer findCustomer(int customerNumber) {
        em = emf.createEntityManager();

        try {
            Query q = em.createQuery("Select c from Customer c where c.id = :number");
            q.setParameter("number", customerNumber);
            return (Customer) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Customer> getAllCustomers() {
        em = emf.createEntityManager();
        List<Customer> results;
        try {
            Query q = em.createQuery("select c FROM Customer c");
            results = q.getResultList();
        } finally {
            em.close();
        }
        return results;
    }
    
    

}
