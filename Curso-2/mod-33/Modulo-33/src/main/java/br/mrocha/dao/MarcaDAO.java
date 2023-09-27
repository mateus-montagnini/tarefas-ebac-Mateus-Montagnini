package br.mrocha.dao;

import br.mrocha.domain.Marca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MarcaDAO implements IMarcaDAO {
    @Override
    public Marca criarMarca(Marca marca) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-modulo33");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return marca;
    }
}
