package main;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws SQLException {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		DBconnect bd = new DBconnect();
		String nomeProfessor;
		Integer auxi;
		Integer in;
		String auxS;
		String auxs;
		List<String> cursos = bd.getDataCurso();

		String[][] ano = bd.getDataAno();
		String[] nomes = bd.getAllData();

		String sal;
		String del;
		Integer im;

		/*
		 * System.out.println("Desejar Cadastrar?"); sal = sc.nextLine();
		 * 
		 * if (sal.equals("s")) { System.out.println("Quantas?"); auxi = sc.nextInt();
		 * for (i = 1; i <= auxi; i++) {
		 * 
		 * System.out.println("Escreva o nome"); auxs = sc.next();
		 * 
		 * System.out.println("Escreva a idade"); sc.nextLine(); auxS = sc.nextLine();
		 * 
		 * bd.insertData(auxs, auxS); }
		 * 
		 * } else { System.out.println("FODASE"); }
		 * 
		 * System.out.println("Deseja exluir tudo?"); del = sc.nextLine(); if
		 * (del.equals("s")) { bd.deleteData("chioda"); bd.deleteData("vitor"); }
		 * 
		 * bd.getAllData();
		 * 
		 */

		sc.close();
		String[][] dia = new String[10][8];
		String[] aula = new String[8];

		Integer i;
		Integer j;
		i = 0;
		j = 0;
		Integer i1;
		Integer j1;
		i1 = 0;
		j1 = 0;
		String eNome;
		Integer idn;
		Integer ia;
		Integer ida;

		for (ia = 0; ia < ano[0].length; ia++) {
			if (ano[0][ia] != null) {
				// System.out.printf(ano[0][ia]);
				// System.out.printf(ano[1][ia]);

				for (in = 0; in < bd.getAllData().length; in++) {

					for (j1 = 0; j1 < 8; j1++) {
						for (i1 = 0; i1 < 5; i1++) {

							String dias = bd.receberDiaSemana(i1);

							String[] dn = bd.getDisponibilidadeAulaByNome(dias, nomes[in]);

							String[] dd = bd.getDisponibilidadeDiaByNome(dias, nomes[in]);

							for (ida = 0; ida < dd.length; ida++) {

								for (idn = 0; idn < dn.length; idn++) {

									if (dn[ida] == null) {

									} else if (dd[ida].equals("segunda")) {

										if (dn[idn] == null) {

										} else {

											if (dn[idn].equals("aula1")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[0][0] = aula[j1];

											} else if (dn[idn].equals("aula2")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[0][1] = aula[j1];
											} else if (dn[idn].equals("aula3")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[0][2] = aula[j1];
											} else if (dn[idn].equals("aula4")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[0][3] = aula[j1];
											} else if (dn[idn].equals("aula5")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[0][4] = aula[j1];
											} else if (dn[idn].equals("aula6")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[0][5] = aula[j1];

											} else if (dn[idn].equals("aula7")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[0][6] = aula[j1];
											} else if (dn[idn].equals("aula8")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[0][7] = aula[j1];
											}

										}
									} else if (dd[ida].equals("terça")) {
										if (dn[idn] == null) {

										} else {
											if (dn[idn].equals("aula1")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[1][0] = aula[j1];

											} else if (dn[idn].equals("aula2")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[1][1] = aula[j1];
											} else if (dn[idn].equals("aula3")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[1][2] = aula[j1];

											} else if (dn[idn].equals("aula4")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[1][3] = aula[j1];
											} else if (dn[idn].equals("aula5")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[1][4] = aula[j1];
											} else if (dn[idn].equals("aula6")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[1][5] = aula[j1];

											} else if (dn[idn].equals("aula7")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[1][6] = aula[j1];
											} else if (dn[idn].equals("aula8")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[1][7] = aula[j1];
											}
										}
									} else if (dd[ida].equals("quarta")) {
										if (dn[idn] == null) {

										} else {
											if (dn[idn].equals("aula1")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[2][0] = aula[j1];

											} else if (dn[idn].equals("aula2")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[2][1] = aula[j1];
											} else if (dn[idn].equals("aula3")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[2][2] = aula[j1];

											} else if (dn[idn].equals("aula4")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[2][3] = aula[j1];
											} else if (dn[idn].equals("aula5")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[2][4] = aula[j1];
											} else if (dn[idn].equals("aula6")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[2][5] = aula[j1];

											} else if (dn[idn].equals("aula7")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[2][6] = aula[j1];
											} else if (dn[idn].equals("aula8")) {

												aula[j1] = bd.getData(nomes[in]);
												dia[2][7] = aula[j1];
											}
										}
									}

								}

							}
						}

					}

				}

			}
		}
		Integer k;
		Integer m;

		for (k = 0; k < 8; k++) {
			for (m = 0; m < 5; m++) {

				if (dia[m][k] != null) {
					System.out.printf(" - ");
					System.out.printf(dia[m][k]);

				} else {
					System.out.printf(" - ");
					System.out.printf("Vazio");
				}
			}
			System.out.println();
		}
	}
}
