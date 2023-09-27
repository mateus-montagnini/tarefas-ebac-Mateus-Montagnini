package br.com.mrocha.jpa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteJpaDAOTest.class, ProdutoJpaDAOTest.class,
        VendaJpaDAOTest.class, ClienteJpaDAOMySQLTest.class
})
public class AllTests {

}
