package com.re;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.StringTokenizer;

import com.bean.EnvironmentDetailsBean;
import com.bean.RunQueryBean;
import com.dao.ConenctorDAO;

public class RunQuery {

	
	public static void main(String[] args) throws SQLException, IOException {
		BufferedReader br = new BufferedReader(
				new FileReader("D:/Work/particular.txt"));
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
				RunQueryBean rBean= new RunQueryBean();
				con.runQuery(con.getDBConnection(dDetails.getEnvName(), dDetails.getDbName(), dDetails.getDbIp(), dDetails.getPortNum(), dDetails.getUname(), dDetails.getPwd()));
				
				
			}
	
		}
		br.close();

}

	}

