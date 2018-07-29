package com.mkyong.listeners;

import org.springframework.batch.core.SkipListener;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.mkyong.BatchConstants;
import com.mkyong.model.Report;

@Component
@Scope(value = "step")
public class MissedItemsSkipListener implements SkipListener<Report, Report> {

	@Value("#{jobParameters['skipCount']}")
	private String skipCount;

	@Value("#{jobParameters['skipDirectory']}")
	private String skipDirectory;

	@Value("#{jobParameters['acquirer']}")
	private String acquirer;

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
	}

}
