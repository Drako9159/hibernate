package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            MissionCommanderEntity commanderJesus = new MissionCommanderEntity();
            commanderJesus.setIdMc(6);
            commanderJesus.setNameMc("Jesus BrujeriaTech");
            commanderJesus.setMission("Backend PHP");

            entityManager.persist(commanderJesus);

            transaction.commit();
        } finally {
            if(transaction.isActive()){
                transaction.rollback();

            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }


}
