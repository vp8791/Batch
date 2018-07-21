package com.mkyong;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mkyong.model.*;
import org.springframework.stereotype.Component;

@Component("jobProcessor")
@Scope(value="step")
public class JobProcessor implements ItemProcessor<Report, Report> {
	
	@Value("#{jobParameters['currentJobStartTime']}")
	private String jobStartTime;

	@Value("#{jobParameters['jobId']}")
	private String jobId;

	
	@Value("#{jobParameters['processingFile']}")
	private String processingFile;
	
	@Value("#{jobParameters['acquirer']}")
	private String acquirer;
	
	@Value("#{jobParameters['chunkCommitSize']}")
	private String chunkCommitSize;
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;

	
	
	@Override
	public Report process(Report inputItem) throws Exception {
		
		String sql = "select TEMP_LINE_NO_SEQ.nextval from dual";
		Long lineNumber = (Long) jdbcTemplate.queryForObject(sql, Long.class);
		
		inputItem.setJobId( jobId);
		inputItem.setLoadedDate(jobStartTime);
		inputItem.setProcessingFile(processingFile);
		inputItem.setAcquirer(acquirer);
		inputItem.setCommitSize(chunkCommitSize);
		inputItem.setLineNumber(Long.toString(lineNumber));
		System.out.println("Processing Item:" + inputItem );
		
		return inputItem;
	}

	

}
