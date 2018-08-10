package com.mkyong.listeners;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.SkipListener;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.mkyong.BatchConstants;
import com.mkyong.model.Report;
import com.mkyong.model.SkipItemsWriter;

@Component
@Scope(value = "step")
public class MissedItemsSkipListener implements SkipListener<Report, Report> {

	@Value("#{jobParameters['skipCount']}")
	private String skipCount;

	@Value("#{jobParameters['skipDirectory']}")
	private String skipDirectory;

	@Value("#{jobParameters['acquirer']}")
	private String acquirer;
	
	@Value("#{jobParameters['processingFile']}")
	private String processingFile;
	
	@Value("#{jobParameters['jobId']}")
	private String jobId;
	

	@Override
	public void onSkipInRead(Throwable t) {
		if (t instanceof FlatFileParseException) {
			FlatFileParseException ffpe = (FlatFileParseException) t;
			StringBuilder errorMessage = new StringBuilder();
			errorMessage.append("An error occured while processing the " + ffpe.getLineNumber()
					+ " line of the file.  Below was the faulty " + "input.\n");
			errorMessage.append(ffpe.getInput() + "\n");
			System.out.println(
					"=============================MissedItemsSkipListener - onSkipInRead:(skipCount, skipDirectory, errorMessage):("
							+ skipCount + "," + skipDirectory + "," + errorMessage + ")");
		} else {
			t.printStackTrace();
		}

	}

	@Override
	public void onSkipInWrite(Report item, Throwable t) {
		System.out.println(
				"=============================MissedItemsSkipListener - onSkipInWrite:(skipCount, skipDirectory, creditCardNumber, acquirer):("
						+ skipCount + "," + skipDirectory + "," + item.getCreditCardNumber() + "," + acquirer   + ")");
	}

	@Override
	public void onSkipInProcess(Report item, Throwable t) {
		System.out.println(
				"=============================MissedItemsSkipListener - onSkipInProcess:(skipCount, skipDirectory, creditCardNumber, acquirer):("
						+ skipCount + "," + skipDirectory + "," + item.getCreditCardNumber() + "," + acquirer   + ")");
		
		SkipItemsWriter skipItem = new SkipItemsWriter();
		skipItem.setCreditCardNumber(item.getCreditCardNumber());
		skipItem.setAcquirer(acquirer);
		skipItem.setProcessingFile(processingFile);
		skipItem.setJobId(Long.valueOf(jobId));
		
		StringBuilder itemToWrite = new StringBuilder();
		itemToWrite.append(skipItem.getCreditCardNumber() + ":" + skipItem.getAcquirer() + ":" + jobId +  ":" + skipItem.getProcessingFile());
		List<String> lines = new ArrayList<String>();
		lines.add(itemToWrite.toString());		
		String skipFileName = (new File(processingFile)).getName() + ".skip";
		File file_to_write = new File(skipDirectory + "/" + skipFileName);
	
		try {
            if(!file_to_write.exists()) {
                List<String> header = new ArrayList<String>();
                header.add("File Record:Acquirer:JobId:Processed File");        
                FileUtils.writeLines(file_to_write, header, false);
            }
            FileUtils.writeLines(file_to_write,lines, true);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write skip file to " + file_to_write.getAbsolutePath() , e);
        }		
	}

}
