package ccl.v2.routine.impl;

import java.util.regex.Matcher;

public class VariableInfo {
	
	public static VariableInfo make(Matcher m){
		return new VariableInfo(m.group(1), m.group(2));
	}
	
	private String name;
	private String value;
	
	public VariableInfo(String name, String value){
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "VariableInfo [name=" + name + ", value=" + value + "]";
	}
	
}
