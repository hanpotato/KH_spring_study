package com.kh.spring.common;

import org.apache.log4j.Logger;

public class Log4jTest {

	private Logger logger = Logger.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		new Log4jTest().logTest();
	}
	
	private void logTest() {
		logger.fatal("FATAL");
		logger.error("ERROR");
		logger.warn("WARN");
		logger.info("INFO");
		logger.debug("DEBUG");
	}
}
