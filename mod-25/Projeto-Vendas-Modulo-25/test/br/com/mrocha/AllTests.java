package br.com.mrocha;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ClientServiceTest.class, ClienteDAOTest.class, ProdutoServiceTest.class, ProdutoDAOTest.class })
public class AllTests {

}
