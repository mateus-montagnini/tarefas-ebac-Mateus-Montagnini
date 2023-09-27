package br.mrocha.dao;

import br.mrocha.domain.Acessorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AcessorioDAO implements IAcessorioDAO {
    @Override
    public Acessorio adicionarAcessorio(Acessorio acessorio) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-modulo33");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return acessorio;
    }
}
