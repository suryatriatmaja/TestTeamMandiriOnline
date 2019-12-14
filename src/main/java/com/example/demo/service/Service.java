package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.config.ConfigDatabase;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Service {

	public static String Table1(String id, String nama, String alamat, String tempat_tgllahir) throws SQLException {
		try {
			Connection con = ConfigDatabase.Database();
			String query = "insert into data_pelamar (id, nama, alamat, tempat_tanggal_lahir) values ('" + id + "','"
					+ nama + "','" + alamat + "','" + tempat_tgllahir + "')";
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
			pst.execute();
			con.close();

			String data = query;
			String message = "Data Berhasil Di input";
			String status = "true";

			String return_data = "{\"Data\":" + "\"" + data + "\"" + ",\"Message\":" + "\"" + message + "\""
					+ ",\"Status\":" + "\"" + status + "\"" + "}";
			return return_data;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String data = "Null";
			String message = e.getMessage();
			String status = "false";

			String return_data = "{\"Data\":" + "\"" + data + "\"" + ",\"Message\":" + "\"" + message + "\""
					+ ",\"Status\":" + "\"" + status + "\"" + "}";
			return return_data;
		}

	}

	public static String Table2(String id, String jurusan, String posisi_lamaran, Integer nilai_sikap,
			Integer nilai_wawancara, Integer nilai_technical_test) {
		try {
			Connection con = ConfigDatabase.Database();
			String query = "insert into tabel_penilaian (id, jurusan, posisi_lamaran, nilai_sikap, nilai_wawancara, nilai_technical_test) values ('"
					+ id + "','" + jurusan + "','" + posisi_lamaran + "'," + nilai_sikap + "," + nilai_wawancara + ","
					+ nilai_technical_test + ")";
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
			pst.execute();
			con.close();

			String data = query;
			String message = "Data Berhasil Di input";
			String status = "true";

			String return_data = "{\"Data\":" + "\"" + data + "\"" + ",\"Message\":" + "\"" + message + "\""
					+ ",\"Status\":" + "\"" + status + "\"" + "}";
			return return_data;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String data = "Null";
			String message = e.getMessage();
			String status = "false";

			String return_data = "{\"Data\":" + "\"" + data + "\"" + ",\"Message\":" + "\"" + message + "\""
					+ ",\"Status\":" + "\"" + status + "\"" + "}";
			return return_data;
		}
	}

	public static String Table3(String id, String nama2) throws SQLException {
		try {
			Connection con = ConfigDatabase.Database();
			String query1 = "SELECT (tabel_penilaian.nilai_wawancara+tabel_penilaian.nilai_sikap+tabel_penilaian.nilai_technical_test/3) as score_final, data_pelamar.id, data_pelamar.nama, data_pelamar.alamat,data_pelamar.tempat_tanggal_lahir,tabel_penilaian.nilai_technical_test ,tabel_penilaian.jurusan, tabel_penilaian.posisi_lamaran FROM data_pelamar INNER JOIN tabel_penilaian ON data_pelamar.id = tabel_penilaian.id WHERE data_pelamar.id='"
					+ id + "'";
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(query1);
			ResultSet rs = pst.executeQuery();
			String result_pelamar = null;
			String score = null;
			String id_result = null;
			while (rs.next()) {

				Double score_final = Double.parseDouble(rs.getString("score_final").toString());
				score = score_final.toString();
				if (score_final > 150) {
					result_pelamar = "SELAMAT ANDA LULUS";
					try {
						String id_pelamar = rs.getString("id");
						String nama = rs.getString("nama");
						String alamat = rs.getString("alamat");
						String tempat_tanggal_lahir = rs.getString("tempat_tanggal_lahir");
						String jurusan = rs.getString("jurusan");
						String posisi_lamaran = rs.getString("posisi_lamaran");
						String status = "LULUS";
						id_result = id_pelamar;

						String queryL = "insert into result (id, nama, alamat, tempat_tanggal_lahir, jurusan, posisi_lamaran, status, score_final) values ('"
								+ id_pelamar + "','" + nama + "','" + alamat + "','" + tempat_tanggal_lahir + "','"
								+ jurusan + "','" + posisi_lamaran + "','" + status + "'," + score_final + ")";
						PreparedStatement pst2 = (PreparedStatement) con.prepareStatement(queryL);
						pst2.execute();
					} catch (Exception e) {
						// TODO: handle exception
					}

				} else {
					result_pelamar = "MAAF ANDA TIDAK LULUS";
					try {
						String id_pelamar = rs.getString("id");
						String nama = rs.getString("nama");
						String alamat = rs.getString("alamat");
						String tempat_tanggal_lahir = rs.getString("tempat_tanggal_lahir");
						String jurusan = rs.getString("jurusan");
						String posisi_lamaran = rs.getString("posisi_lamaran");
						String status = "TIDAK LULUS";
						id_result = id_pelamar;

						String queryL = "insert into result (id, nama, alamat, tempat_tanggal_lahir, jurusan, posisi_lamaran, status, score_final) values ('"
								+ id_pelamar + "','" + nama + "','" + alamat + "','" + tempat_tanggal_lahir + "','"
								+ jurusan + "','" + posisi_lamaran + "','" + status + "'," + score_final + ")";
						PreparedStatement pst2 = (PreparedStatement) con.prepareStatement(queryL);
						pst2.execute();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}

			}

			String message = "SUCCESS";
			String status = "true";
			String result_data = "{\"status\":" + "\"" + result_pelamar + "\"" + ",\"score_final\":" + "\"" + score
					+ "\"" + ",\"id_result\":" + "\"" + id_result + "\"" + "}";

			String return_data = "{\"Data\":" + result_data + ",\"Message\":" + "\"" + message + "\"" + ",\"Status\":"
					+ "\"" + status + "\"" + "}";
			return return_data;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String message = e.getMessage();
			String status = "false";
			String data = "Data Not Found";

			String return_data = "{\"Data\":" + "\"" + data + "\"" + ",\"Message\":" + "\"" + message + "\""
					+ ",\"Status\":" + "\"" + status + "\"" + "}";
			return return_data;
		}

	}

	public static String TableResult() throws SQLException {
		try {
			Connection con = ConfigDatabase.Database();
			String query1 = "SELECT * from result";
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(query1);
			ResultSet rs = pst.executeQuery();
			ArrayList<String> arr_result = new ArrayList<String>();
			while (rs.next()) {
				Double score_final = Double.parseDouble(rs.getString("score_final").toString());
				String id_pelamar = rs.getString("id");
				String nama = rs.getString("nama");
				String alamat = rs.getString("alamat");
				String tempat_tanggal_lahir = rs.getString("tempat_tanggal_lahir");
				String jurusan = rs.getString("jurusan");
				String posisi_lamaran = rs.getString("posisi_lamaran");
				String status = rs.getString("status");

				String result_data = "{\"id_pelamar\":" + "\"" + id_pelamar + "\"" + ",\"nama\":" + "\"" + nama + "\""
						+ ",\"alamat\":" + "\"" + alamat + "\"" + ",\"tempat_tanggal_lahir\":" + "\""
						+ tempat_tanggal_lahir + "\"" + ",\"jurusan\":" + "\"" + jurusan + "\"" + ",\"posisi_lamaran\":"
						+ "\"" + posisi_lamaran + "\"" + ",\"status\":" + "\"" + status + "\"" + ",\"score_final\":"
						+ "\"" + score_final + "\"" + "}";
				arr_result.add(result_data);
			}

			String message = "SUCCESS";
			String status = "true";

			String return_data = "{\"Data\":" + arr_result + ",\"Message\":" + "\"" + message + "\"" + ",\"Status\":"
					+ "\"" + status + "\"" + "}";
			return return_data;

		} catch (Exception e) {
			// TODO: handle exception
			String message = e.getMessage();
			String status = "false";
			String data = "Data Not Found";

			String return_data = "{\"Data\":" + "\"" + data + "\"" + ",\"Message\":" + "\"" + message + "\""
					+ ",\"Status\":" + "\"" + status + "\"" + "}";
			return return_data;
		}

	}

}
