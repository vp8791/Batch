package com.mkyong.model;

public class BasePojo {
	
	private String loadedDate;
	private Long jobId;
	private String processingFile;
	private String acquirer;
	private Long commitSize;
	private Long lineNumber;
	
	public Long getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(Long lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getLoadedDate() {
		return loadedDate;
	}
	public void setLoadedDate(String loadedDate) {
		this.loadedDate = loadedDate;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
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
	public Long getCommitSize() {
		return commitSize;
	}
	public void setCommitSize(Long commitSize) {
		this.commitSize = commitSize;
	}
	

}
