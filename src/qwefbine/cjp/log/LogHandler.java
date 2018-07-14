package qwefbine.cjp.log;

import qwefbine.cjp.log.simple.ConsoleLogger;
import qwefbine.cjp.log.simple.FakeConsoleLogger;

public class LogHandler {
	
	private LogHandler() {
	}
	
	
	
	private static Logger formerLogger;
	
	public static void simpleLoggerSettings(String name, boolean disabled) {
		if(disabled) {
			formerLogger = new FakeConsoleLogger();
		} else {
			formerLogger = new ConsoleLogger(name);
		}
	}
	public static void initLoggerSettings() {
		//TODO integrate with file loggers, like Log4j
	}
	
	
	
	public static Logger getFormatterLogger() {
		return formerLogger.clone();
	}
	
}
