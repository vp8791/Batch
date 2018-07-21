package com.mkyong.model;

public class Report extends BasePojo {
	private String creditCardNumber;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public String toString() {
		return "Report [creditCardNumber=" + creditCardNumber + ", getLineNumber()=" + getLineNumber()
				+ ", getLoadedDate()=" + getLoadedDate() + ", getJobId()=" + getJobId() + ", getProcessingFile()="
				+ getProcessingFile() + ", getAcquirer()=" + getAcquirer() + ", getCommitSize()=" + getCommitSize()
				+ "]";
	}


		
	
}