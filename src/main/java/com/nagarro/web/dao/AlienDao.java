package com.nagarro.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nagarro.web.model.Alien;

public class AlienDao {
	String url = "jdbc:mysql://localhost:3306/jsp_db";
	String username = "root";
	String DBPassword = "";
	public Alien getAlien(int aid) {
		Alien al = new Alien();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection(url,username, DBPassword);
			String sql = "select * from aliens where aid=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, aid);
			System.out.print(st.toString());
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				al.setAid(rs.getInt("aid"));
				al.setAname(rs.getString("name"));
				al.setTech(rs.getString("tech"));
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}
