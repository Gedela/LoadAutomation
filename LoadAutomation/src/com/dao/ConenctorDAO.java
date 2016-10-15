package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.bean.RunQueryBean;


public class ConenctorDAO {
	/*
	 * It is Function it will return the connection as a return type.
	 */
	public Connection getDBConnection(String envName, String dbName,
			String dbip, String portNumber, String uName, String pwd) {
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:db2j:net://" + dbip + ":" + portNumber + "/"
				+ dbName;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, uName, pwd);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	/*
	 * Here I am Getting Custom date from the server where and which i am making
	 * use of Connection.
	 */
	public java.util.Date getCutomdate(Connection con) throws SQLException {

		java.util.Date custom_date = null;
		java.util.Date timestamp_value = null;
		java.sql.Statement st = con.createStatement();
		ResultSet rs = st
				.executeQuery("select DATE_NAME,DATE_VALUE,TIMESTAMP_VALUE  from custom_date where date_name='CUSTOM_DATE'");
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("CUSTOM_DATE"))
				custom_date = rs.getDate(2);
			timestamp_value = rs.getDate(3);
			
			}
		con.close();
		return custom_date;

	}
	
	public String getTimeStamp(Connection con) throws SQLException {

	  String  timestamp_value = null;
		java.sql.Statement st = con.createStatement();
		ResultSet rs = st
				.executeQuery("select DATE_NAME,TIMESTAMP_VALUE  from custom_date where date_name='CUSTOM_DATE'");
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase("CUSTOM_DATE"))
					timestamp_value = rs.getString(2);
			
			}
		con.close();
		return  timestamp_value;

	}

	/*
	 * This method will display the today oz-load details.
	 */
	public void getTodayOzloadDetails(Connection con) throws SQLException {

		java.sql.Statement st = con.createStatement();
		ArrayList<OzloadBean> al = new ArrayList<OzloadBean>();
		ResultSet rs = st
				.executeQuery("select substr(job.job_name,1,20) as job_name, jv.job_start_time, jv.job_end_time, jv.job_status, desc.job_status_desc from job_stats_v jv, job, job_status_desc desc where job.job_id = jv.job_id and job.job_id IN (2000,1999) and date(jv.job_start_time) = current date and jv.job_status = desc.job_status");
		while (rs.next()) {
			OzloadBean ozBean = new OzloadBean();
			ozBean.setJobName(rs.getString(1));
			ozBean.setJobStartTime(rs.getString(2));
			ozBean.setJobEndTime(rs.getString(3));
			ozBean.setJobStatus(rs.getString(4));
			al.add(ozBean);
		}
		con.close();
		Iterator<OzloadBean> i = al.iterator();
		System.out.print("Today Load \t");
		if(al.isEmpty())
			System.out.print("No Load\n");
			
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

	/*
	 * This method will display yesterday oz-load details.
	 */
	public void getYesOzloadDetails(Connection con) throws SQLException {

		java.sql.Statement st = con.createStatement();
		ArrayList<OzloadBean> al = new ArrayList<OzloadBean>();
		ResultSet rs = st
				.executeQuery("select substr(job.job_name,1,20) as job_name, jv.job_start_time, jv.job_end_time, jv.job_status, desc.job_status_desc from job_stats_v jv, job, job_status_desc desc where job.job_id = jv.job_id and job.job_id IN (2000,1999) and date(jv.job_start_time) = current date -1 day and jv.job_status = desc.job_status");
		while (rs.next()) {
			OzloadBean ozBean = new OzloadBean();
			ozBean.setJobName(rs.getString(1));
			ozBean.setJobStartTime(rs.getString(2));
			ozBean.setJobEndTime(rs.getString(3));
			ozBean.setJobStatus(rs.getString(4));
			al.add(ozBean);
		}
		con.close();
		Iterator<OzloadBean> i = al.iterator();
		System.out.print("Yesterday Load \t");
		if(al.isEmpty())
			System.out.print("No Load\n");
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
		
	/*
	 * This method will select the data from database by connecting to it.
	 */
		
		public void runQuery(Connection con) throws SQLException {

			java.sql.Statement st = con.createStatement();
			ArrayList<RunQueryBean> al = new ArrayList<RunQueryBean>();
			ResultSet rs = st
					.executeQuery("select * from service_status  where service_name in ('PrepareOrder', 'PurchaseOrder','OrderStatus', 'OrderServicePurchaseOrderAdapter','OrderServicePrepareOrderAdapter')");
			while (rs.next()) {
				RunQueryBean rBean = new RunQueryBean();
				rBean.setOutput(rs.getString(1));
				rBean.setOutput1(rs.getString(2));
				rBean.setOutput1(rs.getString(3));
				al.add(rBean);
			}
			con.close();
			Iterator<RunQueryBean> i = al.iterator();
			System.out.print("OutPut of Query is: \t");
			if(al.isEmpty())
				System.out.print("No Rows Found\n");
			while (i.hasNext()) {
				System.out.println(i.next());
			}
	}

}
