package br.mrocha.dao;

import br.mrocha.domain.Carro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

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

    @Override
    public Carro buscarPorCodigo(String codigoMarca) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("jpa-modulo33");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM Carro c ");
        sb.append("INNER JOIN Marca m on m = c.marca ");
        sb.append("WHERE m.codigo = :codigoMarca");

        entityManager.getTransaction().begin();
        TypedQuery<Carro> query =
                entityManager.createQuery(sb.toString(), Carro.class);
        query.setParameter("codigoMarca", codigoMarca);
        Carro carro = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return carro;
    }
}
