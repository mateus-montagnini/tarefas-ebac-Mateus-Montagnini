package dao.generic.jdbc.dao;

import dao.generic.jdbc.ConnectionFactory;
import domain.Cliente;
import domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO tb_produto (id, preco, nome) VALUES (nextval('sequence_produto'),?,?)";
            stm = connection.prepareStatement(sql);
            stm.setDouble(1, produto.getPreco());
            stm.setString(2, produto.getNome());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            CloseConnection(connection, stm, null);
        }
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE tb_cliente SET nome = ?, preco = ? WHERE id = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setDouble(2, produto.getPreco());
            stm.setLong(3, produto.getId());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            CloseConnection(connection, stm, null);
        }
    }

    @Override
    public Cliente consultar(String nome) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM tb_produto WHERE nome = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, nome);
            rs = stm.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setCodigo(rs.getString("preco"));
                cliente.setNome(rs.getString("nome"));
            }
        } catch(Exception e) {
            throw e;
        } finally {
            CloseConnection(connection, stm, rs);
        }
        return cliente;
    }

    @Override
    public Integer excluir(Produto clienteBD) throws Exception {
        return null;
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        return null;
    }



    private void CloseConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if(connection != null && !stm.isClosed()) {
                connection.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
