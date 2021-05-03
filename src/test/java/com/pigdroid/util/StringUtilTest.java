package com.pigdroid.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testEmpty() {
		assertTrue(StringUtils.isEmpty(""));
		assertTrue(StringUtils.isEmpty(null));
		assertFalse(StringUtils.isEmpty(" "));
		assertFalse(StringUtils.isEmpty("s"));
	}

	@Test
	public void testSecondFormat() {
		assertEquals("1 second ago", StringUtils.getTimeAgoString(System.currentTimeMillis() - 500L));
	}


	@Test
	public void testSecondsFormat() {
		assertEquals("5 seconds ago", StringUtils.getTimeAgoString(System.currentTimeMillis() - 5000L));
	}


	@Test
	public void testMinuteFormat() {
		assertEquals("1 minute ago", StringUtils.getTimeAgoString(System.currentTimeMillis() - 60000L));
	}


	@Test
	public void testMinutesFormat() {
		assertEquals("2 minutes ago", StringUtils.getTimeAgoString(System.currentTimeMillis() - 120000));
	}

}
