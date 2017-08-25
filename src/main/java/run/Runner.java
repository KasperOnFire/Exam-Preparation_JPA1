package run;

import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kasper
 */
public class Runner {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("kasper_Exam-Preparation_JPA1");
        EntityManager em = emf.createEntityManager();
        
        Facade face = new Facade(emf);
        
        Customer c1 = new Customer("kasper", "test@mail.com");
        face.createCustomer(c1);
        System.out.println(em.find(Customer.class, 0).getName());
        
        
        
        
    }

}
