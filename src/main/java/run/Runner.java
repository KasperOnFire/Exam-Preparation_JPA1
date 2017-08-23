package run;

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
        
        
    }

}
