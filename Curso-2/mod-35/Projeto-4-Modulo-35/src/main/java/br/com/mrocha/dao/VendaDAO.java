package br.com.mrocha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import br.com.mrocha.dao.factory.ProdutoQuantidadeFactory;
import br.com.mrocha.dao.factory.VendaFactory;
import br.com.mrocha.domain.ProdutoQuantidade;
import br.com.mrocha.domain.Venda;
import br.com.mrocha.dao.generic.GenericDAO;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.exceptions.MaisDeUmRegistroException;
import br.com.mrocha.exceptions.TableException;
import br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VendaDAO extends GenericDAO<Venda, String> implements IVendaDAO {


	@Override
	public Class<Venda> getTipoClasse() {
		return Venda.class;
	}

	@Override
	public void atualiarDados(Venda entity, Venda entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setStatus(entity.getStatus());
	}

	@Override
	public void excluir(String valor) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {

		Connection connection = null;
		PreparedStatement stm = null;
		try {
			String sql = "UPDATE tb_venda SET status_venda = ? WHERE id = ?";
			connection = getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, Venda.Status.CONCLUIDA.name());
			stm.setLong(2, venda.getId());
			stm.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Erro ao atualizar ", e);
		} finally {
			closeConnection(connection, stm, null);
		}
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			String sql = "UPDATE tb_venda SET status_venda = ? WHERE id = ?";
			connection = getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, Venda.Status.CANCELADA.name());
			stm.setLong(2, venda.getId());
			stm.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Erro ao atualizar ", e);
		} finally {
			closeConnection(connection, stm, null);
		}
	}

	@Override
	protected String getQueryInsercao() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO tb_venda ");
		sb.append("(id, codigo, id_cliente, valor_total, data_venda, status_venda)");
		sb.append("VALUES (nextval('sq_venda'),?,?,?,?,?)");
		return sb.toString();
	}

	@Override
	protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Venda entity) throws SQLException {
		stmInsert.setString(1, entity.getCodigo());
		stmInsert.setLong(2, entity.getCliente().getId());
		stmInsert.setBigDecimal(3, entity.getValorTotal());
		stmInsert.setTimestamp(4, Timestamp.from(entity.getDataVenda()));
		stmInsert.setString(5, entity.getStatus().name());
	}

	@Override
	protected String getQueryExclusao() {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	protected void setParametrosQueryExclusao(PreparedStatement stmInsert, String valor) throws SQLException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	protected String getQueryAtualizacao() {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Venda entity) throws SQLException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	protected void setParametrosQuerySelect(PreparedStatement stm, String valor) throws SQLException {
		stm.setString(1, valor);
	}



	@Override
	public Venda consultar(String valor) throws MaisDeUmRegistroException, TableException, DAOException {
		//TODO pode ser feito desta forma
//		Venda venda = super.consultar(valor);
//		Cliente cliente = clienteDAO.consultar(venda.getCliente().getId());
//		venda.setCliente(cliente);
//		return venda;

		//TODO Ou pode ser feito com join
		StringBuilder sb = sqlBaseSelect();
		sb.append("WHERE v.codigo = ? ");
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			//validarMaisDeUmRegistro();
			connection = getConnection();
			stm = connection.prepareStatement(sb.toString());
			setParametrosQuerySelect(stm, valor);
			rs = stm.executeQuery();
			if (rs.next()) {
				Venda venda = VendaFactory.convert(rs);
				buscarAssociacaoVendaProdutos(connection, venda);
				return venda;
			}

		} catch (SQLException e) {
			throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
		} finally {
			closeConnection(connection, stm, rs);
		}
		return null;

	}

	private void buscarAssociacaoVendaProdutos(Connection connection, Venda venda)
			throws DAOException {
		PreparedStatement stmProd = null;
		ResultSet rsProd = null;
		try {
			StringBuilder sbProd = new StringBuilder();
			sbProd.append("SELECT pq.id, pq.quantidade, pq.valor_total, ");
			sbProd.append("p.id AS id_produto, p.codigo, p.nome, p.descricao, p.valor ");
			sbProd.append("FROM tb_produto_quantidade pq ");
			sbProd.append("INNER JOIN tb_produto p ON p.id = pq.id_produto_fk ");
			sbProd.append("WHERE pq.id_venda_fk = ?");
			stmProd = connection.prepareStatement(sbProd.toString());
			stmProd.setLong(1, venda.getId());
			rsProd = stmProd.executeQuery();
			Set<ProdutoQuantidade> produtos = new HashSet<>();
			while(rsProd.next()) {
				ProdutoQuantidade prodQ = ProdutoQuantidadeFactory.convert(rsProd);
				produtos.add(prodQ);
			}
			venda.setProdutos(produtos);
			venda.recalcularValorTotalVenda();
		} catch (SQLException e) {
			throw new DAOException("Erro na consulta ", e);
		} finally {
			closeConnection(connection, stmProd, rsProd);
		}
	}



	@Override
	public Collection<Venda> buscarTodos() throws DAOException {
		List<Venda> lista = new ArrayList<>();
		StringBuilder sb = sqlBaseSelect();

		try {
			Connection connection = getConnection();
			PreparedStatement stm = connection.prepareStatement(sb.toString());
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Venda venda = VendaFactory.convert(rs);
				buscarAssociacaoVendaProdutos(connection, venda);
				lista.add(venda);
			}

		} catch (SQLException e) {
			throw new DAOException("Erro na consulta ", e);
		}
		return lista;
	}

	private StringBuilder sqlBaseSelect() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT v.id AS id_venda, v.codigo, v.valor_total, v.data_venda, v.status_venda, ");
		sb.append("c.id AS id_cliente, c.nome, c.cpf, c.tel, c.endereco, c.numero, c.cidade, c.estado ");
		sb.append("FROM tb_venda v ");
		sb.append("INNER JOIN tb_cliente c ON v.id_cliente_fk = c.id ");
		return sb;
	}

	@Override
	public Boolean cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = getConnection();
			stm = connection.prepareStatement(getQueryInsercao(), Statement.RETURN_GENERATED_KEYS);
			setParametrosQueryInsercao(stm, entity);
			int rowsAffected = stm.executeUpdate();

			if(rowsAffected > 0) {
				try (ResultSet rs = stm.getGeneratedKeys()){
					if (rs.next()) {
						entity.setId(rs.getLong(1));
					}
				}

				for (ProdutoQuantidade prod : entity.getProdutos()) {
					stm = connection.prepareStatement(getQueryInsercaoProdQuant());
					setParametrosQueryInsercaoProdQuant(stm, entity, prod);
					rowsAffected = stm.executeUpdate();
				}


				return true;
			}

		} catch (SQLException e) {
			throw new DAOException("Erro no cadastro ", e);
		} finally {
			closeConnection(connection, stm, null);
		}
		return false;
	}

	private String getQueryInsercaoProdQuant() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO tb_produto_quantidade ");
		sb.append("(id, id_produto_fk, id_venda_fk, quantidade, valor_total)");
		sb.append("VALUES (nextval('sq_produto_quantidade'),?,?,?,?)");
		return sb.toString();
	}

	private void setParametrosQueryInsercaoProdQuant(PreparedStatement stm, Venda venda, ProdutoQuantidade prod) throws SQLException {
		stm.setLong(1, prod.getProduto().getId());
		stm.setLong(2, venda.getId());
		stm.setInt(3, prod.getQuantidade());
		stm.setBigDecimal(4, prod.getValorTotal());
	}

}