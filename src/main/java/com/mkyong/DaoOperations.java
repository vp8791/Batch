package com.mkyong;

public interface DaoOperations {
	
	public Long getChunkCommitCount();
	
	public Long getJobId();
	
	public String getLandingDirectory();
	
	public String getProcessingDirectory();
	
	public String getSuccessfullyProcessedDirectory();
	
	public String getErrorDirectory();
	
	public String getSkippableDirectory();
	
	
	public Long getSkipCount();

}
