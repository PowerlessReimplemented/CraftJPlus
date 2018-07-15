package qwefbine.cjp.objects.base;

public interface IComplexData extends ISimpleData {
	
	@Override
	Object[] getData();
	Object getFormattedData();
	
	String getOutput();
	String getFormattedOutput();
	
	@Override
	void printData();
	void printFormattedData();
	
}
