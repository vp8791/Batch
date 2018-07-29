package com.mkyong.listeners;

import java.util.List;

import javax.batch.api.chunk.listener.SkipProcessListener;
import javax.batch.api.chunk.listener.SkipReadListener;
import javax.batch.api.chunk.listener.SkipWriteListener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="step")
public class ItemSkipListener implements SkipProcessListener, SkipReadListener, SkipWriteListener {

	@Value("#{jobParameters['currentJobStartTime']}")
	private String jobStartTime;

	@Value("#{jobParameters['jobId']}")
	private String jobId;

	@Value("#{jobParameters['processingFile']}")
	private String processingFile;

	@Value("#{jobParameters['skipCount']}")
	private String skipCount;

	@Value("#{jobParameters['skipDirectory']}")
	private String skipDirectory;

	@Override
	public void onSkipProcessItem(Object item, Exception ex) throws Exception {
		System.out
				.println("===================================ItemSkipListener - beforeRead:(skipCount, SkipDirectory):"
						+ skipCount + "," + skipDirectory + ")");

	}

	@Override
	public void onSkipReadItem(Exception ex) throws Exception {
		System.out.println(
				"===================================ItemSkipListener - onSkipReadItem:(skipCount, SkipDirectory):"
						+ skipCount + "," + skipDirectory + ")");

	}

	@Override
	public void onSkipWriteItem(List<Object> items, Exception ex) throws Exception {
		System.out.println(
				"===================================ItemSkipListener - onSkipWriteItem:(skipCount, SkipDirectory):"
						+ skipCount + "," + skipDirectory + ")");

	}

}
