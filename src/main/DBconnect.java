package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bd.exceptiom.BDException;

public class DBconnect {
	List<String> namel = new ArrayList<String>();
	String[][] nameA = new String[2][10];
	private String name;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	BDException bde = new BDException();
	Integer i = 0;
	Integer j = 0;

	public DBconnect() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/escolariun?useTimezone=true&serverTimezone=UTC", "root", "");
			st = (Statement) con.createStatement();

		} catch (Exception ex) {
			System.out.println("Erro: " + ex);
		}

	}

	public Connection DBConnect() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/escolariun?useTimezone=true&serverTimezone=UTC", "root", "");
			st = (Statement) con.createStatement();

		} catch (Exception ex) {
			System.out.println("Erro: " + ex);
		}
		return con;

	}

	public String[] getAllData() throws SQLException {
		Integer cont = 0;
		String query = "select * from perfil";
		rs = ((java.sql.Statement) st).executeQuery(query);
		while (rs.next()) {
			cont += 1;
		}

		String[] nomes = new String[cont];
		try {
			String query1 = "select * from perfil";
			rs = ((java.sql.Statement) st).executeQuery(query1);

			if (rs.last() == true) {
				rs = ((java.sql.Statement) st).executeQuery(query1);
				i = 0;
				while (rs.next()) {
					nomes[i] = rs.getString("nome");
					i++;
				}

			} else {
				bde.noDataPerfil();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return nomes;
	}

	public String getData(String id) throws SQLException {
		try {
			String query = "select * from perfil";
			rs = ((java.sql.Statement) st).executeQuery(query);

			if (rs.last() == true) {
				rs = ((java.sql.Statement) st).executeQuery(query);
				while (rs.next()) {

					if (rs.getString("nome").equals(id)) {
						String name = rs.getString("nome");
						return name;
					}
				}
			} else {
				bde.noDataPerfil();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return name;
	}

	public void insertData(String name, String disponibilidade) throws SQLException {
		String sql = "INSERT INTO perfil (nome,disponibilidade) VALUES(?,?)";

		Connection conn = this.DBConnect();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, disponibilidade);
		pstmt.executeUpdate();

	}

	public void deleteData(String name) throws SQLException {
		String sql = "DELETE FROM perfil WHERE nome = ?";
		Connection conn = this.DBConnect();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// set the corresponding param
		pstmt.setString(1, name);
		// execute the delete statement
		pstmt.executeUpdate();

	}

	public void updateData(String name, String name2) throws SQLException {
		String sql = "UPDATE  perfil SET nome=? where nome=? ";
		Connection conn = this.DBConnect();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// set the corresponding param
		pstmt.setString(1, name);
		pstmt.setString(2, name2);
		// execute the delete statement
		pstmt.executeUpdate();

	}

	public List<String> getDataCurso() throws SQLException {

		try {
			String query = "select * from curso";
			rs = ((java.sql.Statement) st).executeQuery(query);

			if (rs.last() == true) {
				rs = ((java.sql.Statement) st).executeQuery(query);
				while (rs.next()) {

					namel.add(rs.getString("nome"));
				}
			} else {
				bde.noDataPerfil();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return namel;
	}

	public String[][] getDataAno() throws SQLException {

		try {
			String query = "select * from segunda";

			rs = ((java.sql.Statement) st).executeQuery(query);
			if (rs.last() == true) {
				rs = ((java.sql.Statement) st).executeQuery(query);

				while (rs.next()) {

					nameA[0][i] = rs.getString("nomeCurso");
					nameA[1][i] = rs.getString("ano");
					i++;

				}
			} else {
				bde.noDataPerfil();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return nameA;
	}

	public String[] getDisponibilidadeAulaByNome(String dia , String nome) throws SQLException {
		i = 0;
		Integer cont = 0;
		String query = "select * from disponiblidade";
		rs = ((java.sql.Statement) st).executeQuery(query);
		while (rs.next()) {
			if (nome.equals(rs.getString("nomeProfessor"))) {
				if(dia.equals(rs.getString("dia"))){
				cont += 1;
				}
			}
		}

		String[] nomes = new String[cont];

		try {
			String query1 = "select * from disponiblidade ";

			rs = ((java.sql.Statement) st).executeQuery(query1);
			if (rs.last() == true) {
				rs = ((java.sql.Statement) st).executeQuery(query1);

				while (rs.next()) {
					if (nome.equals(rs.getString("nomeProfessor"))) {
						if(dia.equals(rs.getString("dia"))){
						nomes[i] = rs.getString("aula");
						i++;
						}
					}

				}
			} else {
				bde.noDataPerfil();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return nomes;
	}

	public String[] getDisponibilidadeDiaByNome(String dia , String nome) throws SQLException {
		i=0;
		Integer cont = 0;
		String query = "select * from disponiblidade";
		rs = ((java.sql.Statement) st).executeQuery(query);
		while (rs.next()) {
			if (nome.equals(rs.getString("nomeProfessor") )) {
				if(dia.equals(rs.getString("dia"))){
				cont += 1;
			}}
		}

		String[] nomes = new String[cont];
		
		try {
			String query1 = "select * from disponiblidade ";

			rs = ((java.sql.Statement) st).executeQuery(query1);
			if (rs.last() == true) {
				rs = ((java.sql.Statement) st).executeQuery(query1);

				while (rs.next()) {
					if (dia.equals(rs.getString("dia"))) {
						nomes[i] = rs.getString("dia");
						i++;
					}

				}
			} else {
				bde.noDataPerfil();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return nomes;
	}

	public String receberDiaSemana(Integer i) {

		String gesuis = null;

		if (i == 0) {
			gesuis = "segunda";
		} else if (i == 1) {
			gesuis = "terça";
		} else if (i == 2) {
			gesuis = "quarta";
		} else if (i == 3) {
			gesuis = "quinta";
		} else if (i == 4) {
			gesuis = "sexta";
		}

		return gesuis;

	}

}
