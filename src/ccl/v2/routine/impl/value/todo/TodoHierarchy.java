package ccl.v2.routine.impl.value.todo;

public class TodoHierarchy {

	private String raw;

	public TodoHierarchy(String raw) {
		this.raw = raw;
		throw new RuntimeException(raw);
	}

	public String getRaw() {
		return raw;
	}

}
