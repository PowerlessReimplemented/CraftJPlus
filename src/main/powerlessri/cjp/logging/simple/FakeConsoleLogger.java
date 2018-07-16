package powerlessri.cjp.logging.simple;

import powerlessri.cjp.logging.Logger;

public class FakeConsoleLogger extends Logger {
	
	@Override
	public void debug(String text) {}
	@Override
	public void info(String text) {}
	@Override
	public void warn(String text) {}
	@Override
	public void fatal(String text) {}
	@Override
	public void error(String text) {}
	
	
	
	@Override
	public Logger clone() {
		return new FakeConsoleLogger();
	}
	
}
