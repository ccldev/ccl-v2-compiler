package ccl.v2.routine.impl.value;

public class ValueRepresentation {
	
	private String raw;
	private int layer;
	private ValueType type;
	
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
		System.out.println(type);
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

}
