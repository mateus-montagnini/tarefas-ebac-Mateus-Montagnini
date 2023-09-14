package br.com.mrocha.jpa;

import br.com.mrocha.dao.jpa.ClienteJpaDAO;
import br.com.mrocha.dao.jpa.ClienteJpaDAOMySQL;
import br.com.mrocha.dao.jpa.IClienteJpaDAO;
import br.com.mrocha.domain.jpa.ClienteJpa;
import br.com.mrocha.domain.jpa.ClienteJpaMySQL;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.exceptions.MaisDeUmRegistroException;
import br.com.mrocha.exceptions.TableException;
import br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class ClienteJpaDAOMySQLTest {

        private IClienteJpaDAO<ClienteJpa> clienteDao;

        private IClienteJpaDAO<ClienteJpaMySQL> clienteMySqlDao;

        private Random random;

        public ClienteJpaDAOMySQLTest() {
            this.clienteDao = new ClienteJpaDAO();
            this.clienteMySqlDao = new ClienteJpaDAOMySQL();
            random = new Random();
        }

        @BeforeEach
        public void end() throws DAOException {
            Collection<ClienteJpa> list = clienteDao.buscarTodos();
            excluir(list, clienteDao);

            Collection<ClienteJpaMySQL> list2 = clienteMySqlDao.buscarTodos();
            excluir2(list2);
        }

        private void excluir(Collection<ClienteJpa> list, IClienteJpaDAO<ClienteJpa> clienteDao) {
            list.forEach(l -> {
                try {
                    clienteDao.excluir(l);
                } catch (DAOException e) {
                    e.printStackTrace();
                }
            });
        }

        private void excluir2(Collection<ClienteJpaMySQL> list) {
            list.forEach(l -> {
                try {
                    clienteMySqlDao.excluir(l);
                } catch (DAOException e) {
                    e.printStackTrace();
                }
            });
        }

        @Test
        public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
            ClienteJpaMySQL cliente = criarCliente2();
            clienteMySqlDao.cadastrar(cliente);

            ClienteJpaMySQL clienteCadastrado = clienteMySqlDao.consultar(cliente.getId());
            Assert.assertNotNull(clienteCadastrado);

        }

        @Test
        public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
            ClienteJpaMySQL cliente = criarCliente2();
            ClienteJpaMySQL retorno = clienteMySqlDao.cadastrar(cliente);
            Assert.assertNotNull(retorno);

            ClienteJpaMySQL clienteCadastrado = clienteMySqlDao.consultar(retorno.getId());
            Assert.assertNotNull(clienteCadastrado);

            clienteMySqlDao.excluir(cliente);

            ClienteJpaMySQL clienteCadastrado1 = clienteMySqlDao.consultar(retorno.getId());
            Assert.assertNull(clienteCadastrado1);
        }

        @Test
        public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
            ClienteJpaMySQL cliente = criarCliente2();
            ClienteJpaMySQL retorno = clienteMySqlDao.cadastrar(cliente);
            Assert.assertNotNull(retorno);

            ClienteJpaMySQL clienteCadastrado = clienteMySqlDao.consultar(cliente.getId());
            Assert.assertNotNull(clienteCadastrado);

            clienteMySqlDao.excluir(cliente);
            clienteCadastrado = clienteMySqlDao.consultar(cliente.getId());
            Assert.assertNull(clienteCadastrado);
        }

        @Test
        public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
            ClienteJpaMySQL cliente = criarCliente2();
            ClienteJpaMySQL retorno = clienteMySqlDao.cadastrar(cliente);
            Assert.assertNotNull(retorno);

            ClienteJpaMySQL clienteCadastrado = clienteMySqlDao.consultar(cliente.getId());
            Assert.assertNotNull(clienteCadastrado);

            clienteCadastrado.setNome("Carlos Henrique");
            clienteMySqlDao.alterar(clienteCadastrado);

            ClienteJpaMySQL novoCliente = clienteMySqlDao.consultar(clienteCadastrado.getId());
            Assert.assertNotNull(novoCliente);
            Assert.assertEquals("Carlos Henrique", novoCliente.getNome());

            clienteMySqlDao.excluir(cliente);
            clienteCadastrado = clienteMySqlDao.consultar(novoCliente.getId());
            Assert.assertNull(clienteCadastrado);
        }

        @Test
        public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
            ClienteJpaMySQL cliente = criarCliente2();
            ClienteJpaMySQL retorno = clienteMySqlDao.cadastrar(cliente);
            Assert.assertNotNull(retorno);

            ClienteJpaMySQL cliente1 = criarCliente2();
            ClienteJpaMySQL retorno1 = clienteMySqlDao.cadastrar(cliente1);
            Assert.assertNotNull(retorno1);

            Collection<ClienteJpa> list = clienteDao.buscarTodos();
            assertTrue(list != null);

        }

        private ClienteJpa criarCliente() {
            ClienteJpa cliente = new ClienteJpa();
            cliente.setCpf(random.nextLong());
            cliente.setNome("Mateus");
            cliente.setCidade("São Paulo");
            cliente.setEnd("Rua Souza, 123");
            cliente.setEstado("SP");
            cliente.setNumero(14);
            cliente.setTel(11987654321L);
            return cliente;
        }

        private ClienteJpaMySQL criarCliente2() {
            ClienteJpaMySQL clienteMySql = new ClienteJpaMySQL();
            clienteMySql.setCpf(random.nextLong());
            clienteMySql.setNome("Mateus");
            clienteMySql.setCidade("São Paulo");
            clienteMySql.setEnd("Rua Souza, 123");
            clienteMySql.setEstado("SP");
            clienteMySql.setNumero(14);
            clienteMySql.setTel(11987654321L);
            return clienteMySql;
        }

    }
