package com.re;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.StringTokenizer;

import com.bean.EnvironmentDetailsBean;
import com.dao.ConenctorDAO;

public class Mcomcretives {

	public static void main(String[] args) throws IOException, SQLException {
		BufferedReader br = new BufferedReader(
				new FileReader("D:/Work/McomEnvLoadDetails.txt"));
//		ArrayList<EnvironmentDetailsBean> edList = new ArrayList<EnvironmentDetailsBean>();
		String strLine;
		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(strLine, ":");
			while (st.hasMoreTokens()) {
				EnvironmentDetailsBean dDetails = new EnvironmentDetailsBean();
				dDetails.setEnvName(st.nextToken());
				dDetails.setDbName(st.nextToken());
				dDetails.setDbIp(st.nextToken());
				dDetails.setPortNum(st.nextToken());
				dDetails.setUname(st.nextToken());
				dDetails.setPwd(st.nextToken());
				ConenctorDAO con = new ConenctorDAO();
				dDetails.setCustom_date(con.getCutomdate(con.getDBConnection(
						dDetails.getEnvName(), dDetails.getDbName(),
						dDetails.getDbIp(), dDetails.getPortNum(),
						dDetails.getUname(), dDetails.getPwd())));
				System.out.println(dDetails.getEnvName()
						+ " Custom Date: "
						+ con.getCutomdate(con.getDBConnection(
								dDetails.getEnvName(), dDetails.getDbName(),
								dDetails.getDbIp(), dDetails.getPortNum(),
								dDetails.getUname(), dDetails.getPwd()))+"\t TimeStamp Value "+con.getTimeStamp(con.getDBConnection(
										dDetails.getEnvName(), dDetails.getDbName(),
										dDetails.getDbIp(), dDetails.getPortNum(),
										dDetails.getUname(), dDetails.getPwd())));
				con.getTodayOzloadDetails(con.getDBConnection(
						dDetails.getEnvName(), dDetails.getDbName(),
						dDetails.getDbIp(), dDetails.getPortNum(),
						dDetails.getUname(), dDetails.getPwd()));
				con.getYesOzloadDetails(con.getDBConnection(
						dDetails.getEnvName(), dDetails.getDbName(),
						dDetails.getDbIp(), dDetails.getPortNum(),
						dDetails.getUname(), dDetails.getPwd()) );
			}
	
		}
		br.close();
	}
}
