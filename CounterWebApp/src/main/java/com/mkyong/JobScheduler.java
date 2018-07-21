package com.mkyong;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.mkyong.DaoOperations;
import com.mkyong.utils.*;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("jobScheduler")
public class JobScheduler {

	@Autowired
	@Qualifier("reportJob")
	private Job job;

	@Autowired
	private DaoOperations daoOperations;

	@Autowired
	private JobLauncher jobLauncher;

	public static List<String> SUPPORTED_ACQUIRERS = Arrays.asList("visa", "mastercard", "amex", "diners");

	public void runDeceptiveDomainsJob() {
		try {
			Date currentJobStartTime = new Date(System.currentTimeMillis());
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			String reportDate = df.format(currentJobStartTime);

			Long jobId = daoOperations.getJobId();
			String landingDirectory = daoOperations.getLandingDirectory();
			String processingDirectry = daoOperations.getProcessingDirectory();
			String successDirectory = daoOperations.getSuccessfullyProcessedDirectory();
			String errorDirectory = daoOperations.getErrorDirectory();
			Long commitCount = daoOperations.getChunkCommitCount();
			System.out.println("==========About to Start Job============");
			for (String acquirer : SUPPORTED_ACQUIRERS) {
				System.out.println("About to Process Job with following parameters");
				System.out.println("jobId(" + jobId + ")");
				System.out.println("landingDirectory(" + landingDirectory + ")");
				System.out.println("processingDirectry(" + processingDirectry + ")");
				System.out.println("successDirectory(" + successDirectory + ")");
				System.out.println("errorDirectory(" + errorDirectory + ")");
				System.out.println("commitSize(" + commitCount + ")");
				System.out.println("jobId(" + jobId + ")");
				
				List<String> filenamestoProcess = BatchFileUtils.getFileNamesToBeProcessed(landingDirectory,
						processingDirectry, acquirer);
				System.out.println("=======Files to be Processed by jobId(" + jobId +")===========" + acquirer + "=====================" + filenamestoProcess.toString());

				for (String processingFileName : filenamestoProcess) {
					System.out.println("Processing  File by JobId(" +  jobId + ")>" + processingFileName + "<  at " + new Date(System.currentTimeMillis()));
					
					JobParameters jobParams = new JobParametersBuilder().addString("currentJobStartTime", reportDate)
							.addString("landingDirectory", landingDirectory)
							.addString("processingDirectry", processingDirectry)
							.addString("successDirectory", successDirectory)
							.addString("errorDirectory", errorDirectory)
							.addString("processingFile", processingFileName)
							.addString("acquirer", acquirer)
							.addString("chunkCommitSize", Long.toString(commitCount))
							.addLong("commitSize", commitCount).
							 addString("jobId", Long.toString(jobId))
							.toJobParameters();
				
					JobExecution execution = jobLauncher.run(job, jobParams);
					
					if (execution.getExitStatus().getExitCode().equals(ExitStatus.FAILED.getExitCode())) {			
						File processFx = new File(processingFileName);	
						String errorFilePath = errorDirectory + "/" + processFx.getName() + "."+ System.currentTimeMillis() + ".error";
						BatchFileUtils.moveFile(processingFileName,  errorFilePath);
						System.out.println("=======Job Failed .. Moved file(" +  processingFileName + ") to (" + errorFilePath + ")" );
					}  
					
					if (execution.getExitStatus().getExitCode().equals(ExitStatus.COMPLETED .getExitCode())) {			
						File processFx = new File(processingFileName);	
						String successFilePath = successDirectory + "/" + processFx.getName() + "."+ System.currentTimeMillis() +  ".success";
						BatchFileUtils.moveFile(processingFileName,  successFilePath);
						System.out.println("=======Job Completed .. Moved file(" +  processingFileName + ") to (" + successFilePath + ")" );
						
					}  
					
					
					
					System.out.println("===============Exit Status========== : " + execution.getStatus());

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}

}
