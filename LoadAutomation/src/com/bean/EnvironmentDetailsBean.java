package com.bean;

import java.util.Date;

public class EnvironmentDetailsBean {
	
	private String envName;
	private String dbName;
	private String dbIp;
	private String portNum;
	private String uname;
	private String pwd;
	private Date custom_date;
	private Date timestamp_value;
	public Date getTimestamp_value() {
		return timestamp_value;
	}
	public void setTimestamp_value(Date timestamp_value) {
		this.timestamp_value = timestamp_value;
	}
	public Date getCustom_date() {
		return custom_date;
	}
	public void setCustom_date(Date custom_date) {
		this.custom_date = custom_date;
	}
	public String getEnvName() {
		return envName;
	}
	public void setEnvName(String envName) {
		this.envName = envName;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbIp() {
		return dbIp;
	}
	public void setDbIp(String dbIp) {
		this.dbIp = dbIp;
	}
	public String getPortNum() {
		return portNum;
	}
	public void setPortNum(String portNum) {
		this.portNum = portNum;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "EnvironmentDetailsBean [envName=" + envName + ", dbName="
				+ dbName + ", dbIp=" + dbIp + ", portNum=" + portNum
				+ ", uname=" + uname + ", pwd=" + pwd + ", custom_date="
				+ custom_date + ", timestamp_value=" + timestamp_value + "]";
	}
	
	

}
