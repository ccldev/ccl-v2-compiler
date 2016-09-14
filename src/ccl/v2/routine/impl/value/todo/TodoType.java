package ccl.v2.routine.impl.value.todo;

public enum TodoType {
	
	GET('G', true),
	INVOKE('(', true);
	
	private char identifier;
	private boolean indexNeeded;

	private TodoType(char identifier, boolean needsIndex){
		this.identifier = identifier;
		this.indexNeeded = needsIndex;
	}

	public String getIdentifier(int layer) {
		if(indexNeeded){
			return identifier + "" + /*(char) */layer;
		}else{
			return "" + (char) layer;
		}
	}

	public boolean isIndexNeeded() {
		return indexNeeded;
	}
	
}
