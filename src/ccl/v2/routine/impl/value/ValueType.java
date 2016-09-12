package ccl.v2.routine.impl.value;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ValueType {
	
	NATIVE("\\(", "\\)"),
	STRING("\"", "\""),
	FLOAT("(\\d+\\.\\d+)"),
	INT("(\\d+)", FLOAT),
	VARIABLE("[a-z]+"),
	ARRAY("[", "]");
	
	private Pattern pattern;
	private ValueType[] betterTypes;
	
	private ValueType(String start, String end, ValueType... better){
		this.pattern = Pattern.compile(start + "(.*)" + end + "\\s*(.*)\\s*", Pattern.DOTALL);
		this.betterTypes = better;
	}
	
	private ValueType(String pattern, ValueType... better){
		this.pattern = Pattern.compile(pattern, Pattern.DOTALL);
		this.betterTypes = better;
	}
	
	public ValueType getMatch(String val){
		Matcher m = pattern.matcher(val);
		if(m.find()){
			for(int i = 0; i < betterTypes.length; i++){
				ValueType betterMatch = betterTypes[i].getMatch(val);
				if(betterMatch != null) return betterMatch.getMatch(val);
			}
			return this;
		}
		return null;
	}
	
}