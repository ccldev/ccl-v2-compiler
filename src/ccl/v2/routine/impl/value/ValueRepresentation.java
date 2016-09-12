package ccl.v2.routine.impl.value;

import java.util.regex.Matcher;

public class ValueRepresentation {
	
	private String raw;
	private int layer;
	private ValueType type;
	private Matcher matcher;
	
	public static ValueRepresentation make(String raw){
		return new ValueRepresentation(raw, 0);
	}
	
	private ValueRepresentation(String raw, int layer){
		this.raw = raw;
		this.layer = layer;
		analyze();
	}

	private void analyze() {
		type = computeType();
		this.matcher = type.matcher(raw);
	}
	
	private ValueType computeType() {
		ValueType[] list = ValueType.values();
		for(int i = 0; i < list.length; i++){
			ValueType t = list[i].getMatch(raw);
			if(t != null){
				return t;
			}
		}
		throw new RuntimeException("No matching value type found for " + this);
	}

	public ValueRepresentation child(String raw){
		return new ValueRepresentation(raw, layer + 1);
	}

	@Override
	public String toString() {
		return "ValueRepresentation [raw=" + raw + ", layer=" + layer
				+ ", type=" + type + "]";
	}
	
	public CompiledValue compile(){
		return ValueCompiler.compile(this);
	}

	public String getRaw() {
		return raw;
	}

	public int getLayer() {
		return layer;
	}

	public ValueType getType() {
		return type;
	}

}
