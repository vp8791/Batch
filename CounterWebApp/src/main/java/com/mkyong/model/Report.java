package com.mkyong.model;

public class Report {
	private String Date;
	private String Impressions;
	private String Clicks;
	private String Earning;
	
	
	private String loadedDate;
	private String jobId;
	private String processingFile;
	private String acquirer;
	private String commitSize;
	
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getImpressions() {
		return Impressions;
	}
	public void setImpressions(String impressions) {
		Impressions = impressions;
	}
	public String getClicks() {
		return Clicks;
	}
	public void setClicks(String clicks) {
		Clicks = clicks;
	}
	public String getEarning() {
		return Earning;
	}
	public void setEarning(String earning) {
		Earning = earning;
	}
	public String getLoadedDate() {
		return loadedDate;
	}
	public void setLoadedDate(String loadedDate) {
		this.loadedDate = loadedDate;
	}

	public String getProcessingFile() {
		return processingFile;
	}
	public void setProcessingFile(String processingFile) {
		this.processingFile = processingFile;
	}
	public String getAcquirer() {
		return acquirer;
	}
	public void setAcquirer(String acquirer) {
		this.acquirer = acquirer;
	}
	public String getCommitSize() {
		return commitSize;
	}
	public void setCommitSize(String commitSize) {
		this.commitSize = commitSize;
	}
	@Override
	public String toString() {
		return "Report [Date=" + Date + ", Impressions=" + Impressions + ", Clicks=" + Clicks + ", Earning=" + Earning
				+ ", loadedDate=" + loadedDate + ", jobId=" + jobId + "]";
	}
	
}