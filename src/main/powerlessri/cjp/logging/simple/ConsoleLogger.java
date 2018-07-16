package powerlessri.cjp.logging.simple;

import java.time.LocalTime;

import powerlessri.cjp.logging.Logger;

public class ConsoleLogger extends Logger {
	
	private String name;
	private String threadName;
	
	private boolean withTime;
	private int builderCapacity;
	private int loggingLevel;
	
	public ConsoleLogger(String name) {
		this(name, false);
	}
	public ConsoleLogger(String name, boolean logWithTime) {
		this(name, "main", logWithTime);
	}
	
	public ConsoleLogger(String name, Thread t) {
		this(name, t, false);
	}
	public ConsoleLogger(String name, Thread t, boolean logWithTime) {
		this(name, t.getName(), logWithTime);
	}
	
	public ConsoleLogger(String name, String threadName) {
		this(name, threadName, false);
	}
	public ConsoleLogger(String name, String threadName, boolean logWithTime) {
		this.name = name;
		this.threadName = threadName;
		this.withTime = logWithTime;
		
		if(this.withTime) {
			this.builderCapacity = 11;
		} else {
			this.builderCapacity = 8;
		}
	}
	
	
	@Override
	public void debug(String text) {
		this.log("DEBUG", text);
	}
	@Override
	public void info(String text) {
		this.log("INFO", text);
	}
	@Override
	public void warn(String text) {
		this.log("WARN", text);
	}
	@Override
	public void fatal(String text) {
		this.log("FATAL", text);
	}
	@Override
	public void error(String text) {
		this.log("ERROR", text);
	}
	
	@Override
	public void error(Throwable e) {
		this.log("ERROR", e.getStackTrace().toString());
	}
	
	
	
	private void log(String prefix, String text) {
		StringBuilder out = new StringBuilder(this.builderCapacity);
		
		if(this.withTime) {
			this.addDate(out);
		}
		
		out.append("[");
		out.append(this.threadName);
		out.append("/");
		out.append(prefix);
		out.append("] [");
		out.append(this.name);
		out.append("] ");
		out.append(text);
		
		System.out.println(out.toString());
	}
	
	private void addDate(StringBuilder builder) {
		builder.append("[");
		builder.append(LocalTime.now().withNano(0));
		builder.append("] ");
	}
	
	
	
	@Override
	public Logger clone() {
		return new ConsoleLogger(name, threadName, withTime);
	}
	
}
