package com.mkyong.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Report extends BasePojo {

	@NotNull
	@Pattern(regexp = "^[0-9]{10,16}$")
	private String creditCardNumber;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public String toString() {
		return "Report [creditCardNumber=" + creditCardNumber + ", getLineNumber()=" + 
				 ", getLoadedDate()=" + getLoadedDate() + ", getJobId()=" + getJobId() + ", getProcessingFile()="
				+ getProcessingFile() + ", getAcquirer()=" + getAcquirer() + ", getCommitSize()=" + getCommitSize()
				+ "]";
	}

}