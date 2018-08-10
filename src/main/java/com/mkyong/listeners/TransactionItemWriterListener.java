package com.mkyong.listeners;

import java.util.List;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.mkyong.model.Report;

@Component
public class TransactionItemWriterListener implements ItemWriteListener<Report> {

	@Override
	public void beforeWrite(List<? extends Report> items) {
		//System.out.println("TransactionItemWriterListener - beforeWrite");
		
	}

	@Override
	public void afterWrite(List<? extends Report> items) {
		//System.out.println("TransactionItemWriterListener - afterWrite");
		
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Report> items) {
	  //System.out.println("TransactionItemWriterListener - onWriteError");	
	}


}
