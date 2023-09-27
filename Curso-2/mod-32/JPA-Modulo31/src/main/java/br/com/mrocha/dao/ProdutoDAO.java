package br.com.mrocha.dao;

import br.com.mrocha.domain.Produto;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

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

    @Override
    public Produto consultarId(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-modulo31");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Produto produto = entityManager.find(Produto.class, id);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public void excluir(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-modulo31");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public Produto atualizar(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-modulo31");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public List<Produto> buscarTodos() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-modulo31");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Produto> lista = entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return lista;
    }
}
