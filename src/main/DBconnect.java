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

	public void insertData(String name, String age, Integer nota) throws SQLException {
		String sql = "INSERT INTO perfil (nome,age,nota) VALUES(?,?,?)";

		Connection conn = this.DBConnect();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, age);
		pstmt.setInt(3, nota);
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

	public String[] getDataCurso() throws SQLException {

		Integer cont = 0;
		String query = "select * from curso";
		rs = ((java.sql.Statement) st).executeQuery(query);

		if (rs.last() == true) {
			rs = ((java.sql.Statement) st).executeQuery(query);
			while (rs.next()) {

				cont++;
			}

		}
		String[] namel = new String[cont];
		cont = 0;
		try {

			String query1 = "select * from curso";
			rs = ((java.sql.Statement) st).executeQuery(query1);

			if (rs.last() == true) {
				rs = ((java.sql.Statement) st).executeQuery(query1);
				while (rs.next()) {

					namel[cont] = (rs.getString("nome"));
					cont++;
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

	public String[] getDisponibilidadeAulaByNome(String dia, String nome) throws SQLException {
		i = 0;
		Integer cont = 0;
		String query = "select * from disponiblidade";
		rs = ((java.sql.Statement) st).executeQuery(query);
		while (rs.next()) {
			if (nome.equals(rs.getString("nomeProfessor"))) {
				if (dia.equals(rs.getString("dia"))) {
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
						if (dia.equals(rs.getString("dia"))) {
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

	public String[] getDisponibilidadeAulaByCurso(String nome, String curso, String dia) throws SQLException {
		i = 0;
		Integer cont = 0;
		String query = "select * from disponiblidade";
		rs = ((java.sql.Statement) st).executeQuery(query);

		while (rs.next()) {
			if (nome.equals(rs.getString("nomeProfessor")) && curso.equals(rs.getString("curso"))
					&& dia.equals(rs.getString("dia"))) {

				cont += 1;

			}
		}

		String[] nomes = new String[cont];
		i = 0;
		try {
			String query1 = "select * from disponiblidade ";

			rs = ((java.sql.Statement) st).executeQuery(query1);
			if (rs.last() == true) {
				rs = ((java.sql.Statement) st).executeQuery(query1);
				cont = 0;
				while (rs.next()) {

					if (nome.equals(rs.getString("nomeProfessor")) && curso.equals(rs.getString("curso"))
							&& dia.equals(rs.getString("dia"))) {

						nomes[i] = rs.getString("aula");

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

	public String[] getDisponibilidadeDiaByNome(String dia, String nome) throws SQLException {
		i = 0;
		Integer cont = 0;
		String query = "select * from disponiblidade";
		rs = ((java.sql.Statement) st).executeQuery(query);
		while (rs.next()) {
			if (nome.equals(rs.getString("nomeProfessor"))) {
				if (dia.equals(rs.getString("dia"))) {
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

	public String receberAula(Integer i) {

		String gesuis = null;

		if (i == 0) {
			gesuis = "aula1";
		} else if (i == 1) {
			gesuis = "aula2";
		} else if (i == 2) {
			gesuis = "aula3";
		} else if (i == 3) {
			gesuis = "aula4";
		} else if (i == 4) {
			gesuis = "aula5";
		} else if (i == 5) {
			gesuis = "aula6";
		} else if (i == 6) {
			gesuis = "aula7";
		} else if (i == 7) {
			gesuis = "aula8";
		}

		return gesuis;

	}

	public Integer getNotaByNome(String nome) {
		Integer notaa = null;
		try {
			String query = "select * from perfil";

			rs = ((java.sql.Statement) st).executeQuery(query);
			if (rs.last() == true) {
				rs = ((java.sql.Statement) st).executeQuery(query);

				while (rs.next()) {
					if (nome.equals(rs.getString("nome"))) {
						notaa = rs.getInt("nota");
					}

				}
			} else {
				bde.noDataPerfil();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return notaa;
	}

	public void CadastroAula(Integer dia, String curso, String aula1, String aula2, String aula3, String aula4,
			String aula5, String aula6, String aula7, String aula8) throws SQLException {
		try {
			String sql = null;

			if (dia == 0) {
				sql = "INSERT INTO segunda (nomeCurso,aula1,aula2,aula3,aula4,aula5,aula6,aula7,aula8) VALUES(?,?,?,?,?,?,?,?,?)";
			} else if (dia == 1) {
				sql = "INSERT INTO terca (nomeCurso,aula1,aula2,aula3,aula4,aula5,aula6,aula7,aula8) VALUES(?,?,?,?,?,?,?,?,?)";
			} else if (dia == 2) {
				sql = "INSERT INTO quarta (nomeCurso,aula1,aula2,aula3,aula4,aula5,aula6,aula7,aula8) VALUES(?,?,?,?,?,?,?,?,?)";
			} else if (dia == 3) {
				sql = "INSERT INTO quinta (nomeCurso,aula1,aula2,aula3,aula4,aula5,aula6,aula7,aula8) VALUES(?,?,?,?,?,?,?,?,?)";
			} else if (dia == 4) {
				sql = "INSERT INTO sexta (nomeCurso,aula1,aula2,aula3,aula4,aula5,aula6,aula7,aula8) VALUES(?,?,?,?,?,?,?,?,?)";
			}

			Connection conn = this.DBConnect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, curso);
			pstmt.setString(2, aula1);
			pstmt.setString(3, aula2);
			pstmt.setString(4, aula3);
			pstmt.setString(5, aula4);
			pstmt.setString(6, aula5);
			pstmt.setString(7, aula6);
			pstmt.setString(8, aula7);
			pstmt.setString(9, aula8);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public String AlocarAula(String nomeP, String cursoEscolhido, String diaSemana, String aulaNumero) {

		String alocar = null;
		try {
			String query2 = "select * from disponiblidade ";

			rs = ((java.sql.Statement) st).executeQuery(query2);
			if (rs.last() == true) {
				rs = ((java.sql.Statement) st).executeQuery(query2);

				while (rs.next()) {

					if (nomeP.equals(rs.getString("nomeProfessor"))) {
						if (diaSemana.equals(rs.getString("dia"))) {
							if (aulaNumero.equals(rs.getString("aula"))) {
								if (cursoEscolhido.equals(rs.getString("curso"))) {
									alocar = rs.getString("nomeProfessor");

								}
							}
						}

					} else {
						
					}
				}
			} else {
				bde.noDataPerfil();
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return alocar;

	}
	
	public String mudarProfessorPorPontos (String nome1, String nome2) {
		String nomeCerto = null;
		String[] nomev = new String[2];
		Integer[] notav = new Integer[2];
		i=0;
		
		try {
			String query = "select * from perfil";
			rs = ((java.sql.Statement) st).executeQuery(query);
			if (rs.last() == true) {
				rs = ((java.sql.Statement) st).executeQuery(query);

				while (rs.next()) {
					if ((nome1.equals(rs.getString("nome"))) || (nome2.equals(rs.getString("nome")))  ) {
						nomev[i] = rs.getString("nome");
						notav[i] = rs.getInt("nota");
						i++;
					}

				}
			} else {
				bde.noDataPerfil();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		if(notav[0]>notav[1]) {
			nomeCerto = nomev[0]; 
		}else {
			nomeCerto = nomev[1];
		}
		return nomeCerto;
		
	}
	
	public String verificarAulaPorNome (String dia,String aula,String nome, String curso) {
		
		String nome2= "null";
	
		try {
			String query = "select * from disponiblidade";

			rs = ((java.sql.Statement) st).executeQuery(query);
			if (rs.last() == true) {
				rs = ((java.sql.Statement) st).executeQuery(query);

				while (rs.next()) {
					if (nome.equals(rs.getString("nomeProfessor"))) {
						if(dia.equals(rs.getString("dia"))) {
							if(aula.equals(rs.getString("aula"))){
								if(curso.equals(rs.getString("curso"))) {
									nome2="true";
								}
								
							}
						}
					}

				}
			} else {
				bde.noDataPerfil();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		
		
		return nome2;
	}
	
	
}
