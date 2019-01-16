package main;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class main {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws SQLException {
		System.out.println("Ola");
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		DBconnect bd = new DBconnect();

		Integer in;

		String[] cursos = bd.getDataCurso();

		String[] nomes = bd.getAllData();

		sc.close();
		String[][][] dia = new String[20][10][8];
		String[] aula = new String[8];

		Integer i1;
		Integer j1;
		i1 = 0;
		j1 = 0;

		Integer c;
		Integer ia;

		for (ia = 0; ia < cursos.length; ia++) {
			System.out.println(ia + "s");

			for (in = 0; in < bd.getAllData().length; in++) {

				for (j1 = 0; j1 < 8; j1++) {

					for (i1 = 0; i1 < 5; i1++) {

						String dias = bd.receberDiaSemana(i1);

						String aulaString = bd.receberAula(j1);

						String alocarAula = bd.AlocarAula(nomes[in], cursos[ia], dias, aulaString);
						String verificarAula = bd.verificarAulaPorNome(dias, aulaString, nomes[in], cursos[ia]);
						if (dia[ia][i1][j1] != null) {
							if (verificarAula.equals("true")) {
								dia[ia][i1][j1] = bd.mudarProfessorPorPontos(dia[ia][i1][j1], nomes[in]);
							} else {

							}
						} else {
							dia[ia][i1][j1] = alocarAula;
						}
					}

				}

			}
		}

		Integer k;
		Integer m;
		Integer cc;

		k = 0;
		m = 0;
		cc = 0;

		for (cc = 0; cc < cursos.length; cc++) {
			for (k = 0; k < 8; k++) {
				for (m = 0; m < 5; m++) {

					if (dia[cc][m][k] == null) {
						dia[cc][m][k] = "vazio";
					}

				}
			}
		}

		k = 0;
		m = 0;
		cc = 0;

		for (cc = 0; cc < cursos.length; cc++) {
			System.out.println(cursos[cc]);
			for (k = 0; k < 8; k++) {
				for (m = 0; m < 5; m++) {

					System.out.printf(" - ");
					System.out.print(dia[cc][m][k]);

				}
				System.out.println();
			}
			System.out.println();
		}

		c = 0;
		k = 0;

		for (c = 0; c < cursos.length; c++) {
			for (k = 0; k < 5; k++) {
				bd.CadastroAula(k, cursos[c], dia[c][k][0], dia[c][k][1], dia[c][k][2], dia[c][k][3], dia[c][k][4],
						dia[c][k][5], dia[c][k][6], dia[c][k][7]);
			}
		}

	}
}
