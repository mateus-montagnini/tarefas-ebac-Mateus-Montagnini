package br.mrocha.dao;

import br.mrocha.domain.Carro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CarroDAO implements ICarroDAO {
    @Override
    public Carro criarCarro(Carro carro) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-modulo33");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return carro;
    }
}
