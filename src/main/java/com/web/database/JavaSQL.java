package com.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.web.services.TrainBean;

public class JavaSQL {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/"; 

	// Database credentials
	static final String USER = "root";
	static final String PASS = "password";
	Connection conn = null;
	Statement stmt = null;

	public JavaSQL() {
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<TrainBean> fetchTrains(String source, String destination, LocalDate date) {
		try {
			// STEP 4: Execute a query
			stmt = conn.createStatement();

			String st = "USE IRCTC";
			stmt.execute(st);
			List<TrainBean> trainBeans = new ArrayList<TrainBean>(); 
			DayOfWeek sDay = date.getDayOfWeek();
			String availDay = sDay.getDisplayName(TextStyle.SHORT, Locale.getDefault());
			String sql = "SELECT train.train_id,train_name,source,destination,route_mapping.route_id,seats, days FROM route_mapping JOIN availability on route_mapping.id=availability.id "
					+ "join route on route_mapping.route_id=route.route_id join train on train.train_id= route_mapping.train_id where FIND_IN_SET('"
					+ availDay + "'" + ",days) and date='" + date + "' and source='"+source+"'and destination='"+destination+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TrainBean trainBean = new TrainBean();
				// Retrieve by column name
				int train_id = rs.getInt("train_id");
				String train = rs.getString("train_name");
				String source1 = rs.getString("source");
				String destination1 = rs.getString("destination");
				long seats = rs.getInt("seats");
				trainBean.setTrainId(train_id);
				trainBean.setTrainName(train);
				trainBean.setSource(source1);
				trainBean.setDestination(destination1);
				trainBean.setSeats((int)seats);
				trainBeans.add(trainBean);
			}
			rs.close();
			return trainBeans;
		} catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}
		return null;
	}
	

	
	public static void main(String[] args) {
		
		TrainBean trainBean= new TrainBean();
		trainBean.setSource("Bhopal");
		trainBean.setDestination("New Delhi");
		String src=trainBean.getSource();
		String dest=trainBean.getDestination();
		LocalDate startDate = LocalDate.now();
		System.out.println();
		JavaSQL javaSQL = new JavaSQL();
		System.out.println(javaSQL.fetchTrains(src,dest,startDate));
	}
}