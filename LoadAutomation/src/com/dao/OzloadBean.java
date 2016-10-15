package com.dao;



public class OzloadBean {
	private String jobName;
	private String jobStartTime;
	private String jobEndTime;
	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	private String jobStatus;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobStartTime() {
		return jobStartTime;
	}

	public void setJobStartTime(String jobStartTime) {
		this.jobStartTime = jobStartTime;
	}

	public String getJobEndTime() {
		return jobEndTime;
	}

	public void setJobEndTime(String jobEndTime) {
		this.jobEndTime = jobEndTime;
	}

	@Override
	public String toString() {
		return  jobName + "\t"+ jobStartTime +"\t"+ jobEndTime +"\t"+ jobStatus;
	}

	
}
