package com.example.demo.config;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.demo.controller.Controller;
import com.example.demo.service.Service;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ConfigDatabase {

	public static Connection Database() throws SQLException {
		String url = "jdbc:mysql://localhost:3316/data_calaon_pegawai?useSSL=false";
		String user = "root";
		String password = "";
		Connection con = (Connection) DriverManager.getConnection(url, user, password);
		return con;
	}

}
