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
		return "Acquirer Data [creditCardNumber=" + creditCardNumber + ", getLoadedDate()=" + getLoadedDate() + ", getJobId()="
				+ getJobId() + ", getProcessingFile()=" + getProcessingFile() + ", getAcquirer()=" + getAcquirer()
				+ ", getCommitSize()=" + getCommitSize() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

		
	
}