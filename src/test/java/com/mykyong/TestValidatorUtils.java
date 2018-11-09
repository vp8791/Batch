package com.mykyong;

import java.util.Date;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.test.util.ReflectionTestUtils;

import com.mkyong.model.Report;
import com.mkyong.validators.BeanValidator;

public class TestValidatorUtils {

	private BeanValidator beanValidator;

	public TestValidatorUtils() {
		beanValidator = new BeanValidator();
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = validatorFactory.usingContext().getValidator();
		ReflectionTestUtils.setField(beanValidator, "validator", validator);
	}

	public BeanValidator getBeanValidator() {
		return beanValidator;
	}

	public Report getValidReport() {
		Report report = new Report();
		report.setCreditCardNumber("3088301302703708");
		Date currentDate = new Date(System.currentTimeMillis());
		Date oneDayBefore = new Date(currentDate.getTime() - 10);
		report.setOrderDate(oneDayBefore);
		
		report.setAmount("996");
		
		
		return report;
	}

}
