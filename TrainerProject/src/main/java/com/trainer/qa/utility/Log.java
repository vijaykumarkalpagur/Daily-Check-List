package com.trainer.qa.utility;

import org.apache.log4j.Logger;

public class Log {

	//Creating an instance of logger class globally
	public static Logger Log = Logger.getLogger("Log");
	
	public static void startTestCase(String sTestCaseName){
		Log.info("********************************************************************");
		Log.info("************              "+sTestCaseName+ "          **************");
		Log.info("********************************************************************");
	}
	// This is to print log for the ending of the test case
	
	public static void Succesful(String sTestCaseName){
		
		Log.info("****************************"+"TestEnd"+"****************************");
			
	}

	//It will debug information and is helpful to debug an application.
	public static void debug(String message) {

		  Log.debug(message);
	}

	//It will show informational message that highlights the progress of the application.
	public static void info(String message) {

			Log.info(message);
	}

	//It warns at harmful situations.
	public static void warn(String message) {

	  Log.warn(message);
	}

	//It will show error events that might still allow the application to continue running.
	public static void error(String message) {

	  Log.error(message);
	}

	// It is very severe error events that presumably lead the application to crash
	public static void fatal(String message) {

	  Log.fatal(message);

	}
}
