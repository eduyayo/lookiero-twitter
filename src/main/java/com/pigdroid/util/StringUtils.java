package com.pigdroid.util;

import java.util.concurrent.TimeUnit;

public class StringUtils {

	private StringUtils() {
	}

	public static boolean isEmpty(String in) {
		return isNull(in) || "".equals(in);
	}

	public static boolean isNull(String in) {
		return in == null;
	}

	public static boolean isNotEmpty(String in) {
		return !isNull(in) && !"".equals(in);
	}

	public static String getTimeAgoString(long creationTime) {
		long millis = System.currentTimeMillis() - creationTime;
		long hs = TimeUnit.MILLISECONDS.toHours(millis);
		long ms = TimeUnit.MILLISECONDS.toMinutes(millis);
		long ss = TimeUnit.MILLISECONDS.toSeconds(millis);
		if (ss == 0) {
			ss = 1;
		}
		String ret = "";
		if (hs > 0) {
			String s = hs > 1 ? "s" : "";
			ret = String.format("%d hour%s ago", hs, s);
		} else if (ms > 0) {
			String s = ms > 1 ? "s" : "";
			ret = String.format("%d minute%s ago", ms, s);
		} else {
			String s = ss > 1 ? "s" : "";
			ret = String.format("%d second%s ago", ss, s);
		}
		return ret;
	}

}
