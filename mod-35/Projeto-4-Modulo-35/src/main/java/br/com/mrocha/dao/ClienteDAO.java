package br.com.mrocha.dao;

import br.com.mrocha.dao.generic.GenericDAO;
import br.com.mrocha.domain.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

	public ClienteDAO() {
		super();
	}

	@Override
	public Class<Cliente> getTipoClasse() {
		return Cliente.class;
	}

	@Override
	public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
		entityCadastrado.setCidade(entity.getCidade());
		entityCadastrado.setCpf(entity.getCpf());
		entityCadastrado.setEnd(entity.getEnd());
		entityCadastrado.setCep(entity.getCep());
		entityCadastrado.setEstado(entity.getEstado());
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setNumero(entity.getNumero());
		entityCadastrado.setTel(entity.getTel());
	}

	@Override
	protected String getQueryInsercao() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO tb_cliente ");
		sb.append("(id, nome, cpf, tel, endereco, cep, numero, cidade, estado)");
		sb.append("VALUES (nextval('sq_cliente'),?,?,?,?,?,?,?,?);");
		return sb.toString();
	}

	@Override
	protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente entity) throws SQLException {
		stmInsert.setString(1, entity.getNome());
		stmInsert.setLong(2, entity.getCpf());
		stmInsert.setLong(3, entity.getTel());
		stmInsert.setString(4, entity.getEnd());
		stmInsert.setLong(5, entity.getCep());
		stmInsert.setLong(6, entity.getNumero());
		stmInsert.setString(7, entity.getCidade());
		stmInsert.setString(8, entity.getEstado());
	}

	@Override
	protected String getQueryExclusao() {
		return "DELETE FROM tb_cliente WHERE cpf = ?";
	}

	@Override
	protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long valor) throws SQLException {
		stmExclusao.setLong(1, valor);
	}
	
	@Override
	protected String getQueryAtualizacao() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE tb_cliente ");
		sb.append("SET nome = ?,");
		sb.append("tel = ?,");
		sb.append("endereco = ?,");
		sb.append("cep = ?,");
		sb.append("numero = ?,");
		sb.append("cidade = ?,");
		sb.append("estado = ?");
		sb.append(" WHERE cpf = ?");
		return sb.toString();
	}

	@Override
	protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente entity) throws SQLException {
		stmUpdate.setString(1, entity.getNome());
		stmUpdate.setLong(2, entity.getTel());
		stmUpdate.setString(3, entity.getEnd());
		stmUpdate.setLong(4, entity.getCep());
		stmUpdate.setLong(5, entity.getNumero());
		stmUpdate.setString(6, entity.getCidade());
		stmUpdate.setString(7, entity.getEstado());
		stmUpdate.setLong(8, entity.getCpf());
	}

	@Override
	protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
		stmSelect.setLong(1, valor);
	}

}
