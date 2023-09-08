package br.com.mrocha.dao;

import br.com.mrocha.domain.Produto;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public Produto cadastrar(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-modulo31");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }
}
