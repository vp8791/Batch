package com.mkyong.model;

public class BasePojo {
	
	private String loadedDate;
	private String jobId;
	private String processingFile;
	private String acquirer;
	private String commitSize;
	private String lineNumber;
	
	public String getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getLoadedDate() {
		return loadedDate;
	}
	public void setLoadedDate(String loadedDate) {
		this.loadedDate = loadedDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
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
	

}
