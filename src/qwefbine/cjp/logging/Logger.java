package qwefbine.cjp.logging;

import qwefbine.cjp.exceptions.MethodNotSupportedException;

public abstract class Logger implements Cloneable {
	
	public void debug() {}
	public void info() {}
	public void warn() {}
	public void fatal() {}
	public void error() {}
	
	public void debug(String text) {}
	public void info(String text) {}
	public void warn(String text) {}
	public void fatal(String text) {}
	public void error(String text) {}
	
	public void error(Throwable e) {}
	
	
	@Override
	public Logger clone() {
		throw new MethodNotSupportedException();
	}
	
}
