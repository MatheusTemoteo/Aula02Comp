package aula02.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatternFactoryDao {
	public void incluir(PatternFactoryDao to) {
		String sqlInsert = "INSERT INTO cliente(id, pais,populacao,area ) VALUES (?, ?, ?, ?)";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getId());
			stm.setString(2, to.getPais());
			stm.setLong(3, to.getPopulacao());
			stm.setDouble(4, to.getArea());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private String getPais() {
		// TODO Auto-generated method stub
		return null;
	}

	private long getPopulacao() {
		// TODO Auto-generated method stub
		return 0;
	}

	private double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void atualizar(PatternFactoryDao to) {
		String sqlUpdate = "UPDATE cliente SET pais=?, populacao=?,area=? WHERE id=?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getPais());
			stm.setLong(2, to.getPopulacao());
			stm.setDouble(3, to.getArea());
			stm.setInt(4, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void excluir(PatternFactoryDao to) {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	public PatternFactoryDao carregar(int id) {
		PatternFactoryDao to = new PatternFactoryDao();
		String sqlSelect = "SELECT nome, fone FROM cliente WHERE cliente.id = ?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setPais(rs.getString("pais"));
					to.setPopulacao(rs.getLong("populacao"));
					to.setArea(rs.getDouble("area"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

	private void setPopulacao(long long1) {
		// TODO Auto-generated method stub
		
	}

	private void setPais(String string) {
		// TODO Auto-generated method stub
		
	}
}

