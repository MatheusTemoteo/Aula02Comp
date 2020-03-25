package aula02.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatternDao {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	// Obtémconexãocom o bancodedados
	public Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/tutorial?user=alunos&password=alunos");
	}
	public void incluir(int id, String nome, long populacao, double area) {
		String sqlInsert = "INSERT INTO cliente(id, nome, populacao, area) VALUES (?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, id);
			stm.setString(2, nome);
			stm.setLong(3, populacao);
			stm.setDouble(4, area);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void atualizar(int id,String nome ,long populacao, double area) {
		String sqlUpdate = "UPDATE cliente SET nome=?, populacao=?,area=? WHERE id=?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, nome);
			stm.setLong(2, populacao);
			stm.setDouble(3, area);
			stm.setInt(4, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })

	public ArrayList carregar(int id) {
		ArrayList retorno = new ArrayList();
		String sqlSelect = "SELECT nome, fone FROM cliente WHERE cliente.id = ?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					retorno.add(rs.getString("nome"));
					retorno.add(rs.getLong("populcao"));
					retorno.add(rs.getDouble("area"));
				} else {
					retorno.add(null);
					retorno.add(null);
					retorno.add(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return retorno;
	}
	public void criar() {
		// TODO Auto-generated method stub
		
	}
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}
	public void setNome(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setPopulacao(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setArea(String string) {
		// TODO Auto-generated method stub
		
	}}

