package com.mkyong;

import java.util.concurrent.atomic.AtomicLong;

public class SequenceGenerator {
	private static AtomicLong visa;
	private static AtomicLong mastercard;
	private static AtomicLong amex;
	private static AtomicLong diners;
	private static AtomicLong discover;
	private static AtomicLong enroute;
	private static AtomicLong jcb;
	private static AtomicLong voyager;

	private static SequenceGenerator obj = null;

	private SequenceGenerator(int initialValue) {
		this.visa = new AtomicLong(initialValue);
		this.mastercard = new AtomicLong(initialValue);
		this.amex = new AtomicLong(initialValue);
		this.diners = new AtomicLong(initialValue);
		this.discover = new AtomicLong(initialValue);
		this.enroute = new AtomicLong(initialValue);
		this.jcb = new AtomicLong(initialValue);
		this.voyager = new AtomicLong(initialValue);
	}

	public static SequenceGenerator getInstance() {
		obj = new SequenceGenerator(1);
		return obj;
	}

	public static long getCounter(String acquirer) {
		if (acquirer.equals(BatchConstants.VISA_ACQUIRER)) {
			return visa.getAndIncrement();
		} else if (acquirer.equals(BatchConstants.MASTERCARD_ACQUIRER)) {
			return mastercard.getAndIncrement();
		} else if (acquirer.equals(BatchConstants.AMEX_ACQUIRER)) {
			return amex.getAndIncrement();
		} else if (acquirer.equals(BatchConstants.DINERS_ACQUIRER)) {
			return diners.getAndIncrement();
		} else if (acquirer.equals(BatchConstants.DISCOVER_ACQUIRER)) {
			return discover.getAndIncrement();
		} else if (acquirer.equals(BatchConstants.ENROUTE_ACQUIRER)) {
			return enroute.getAndIncrement();
		} else if (acquirer.equals(BatchConstants.JCB_ACQUIRER)) {
			return jcb.getAndIncrement();
		} else if (acquirer.equals(BatchConstants.VOYAGER_ACQUIRER)) {
			return voyager.getAndIncrement();
		} else {
			throw new RuntimeException("Acquirer(" + acquirer + ") not supported");
		}

	}
}