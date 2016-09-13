package ccl.v2.routine.impl.value.todo;

import java.util.ArrayList;

public class TodoElement {

	private StringBuilder builder;
	private ArrayList<TodoElement> children;
	private TodoElement parent;
	private TodoDescription description;
	
	public static TodoElement make(){
		return new TodoElement(null);
	}
	
	private TodoElement(TodoElement parent){
		this.parent = parent;
		builder = new StringBuilder();
		children = new ArrayList<TodoElement>();
	}
	
	public void feed(char next) {
		builder.append(next);
	}
	
	public boolean isEmpty(){
		return builder.toString().trim().isEmpty();
	}

	public TodoElement child() {
		TodoElement e = new TodoElement(this);
		children.add(e);
		return e;
	}

	public TodoElement parent() {
		return parent;
	}

	@Override
	public String toString() {
		return "TodoElement [builder=" + builder + ", children=" + children + "]";
	}

	private void analyze() {
		description = new TodoDescription(builder.toString());
	}

	public TodoDescription getDescription() {
		if(description == null) analyze();
		return description;
	}
	
	public String getRaw(){
		return builder.toString().trim();
	}

	public ArrayList<TodoElement> getChildren() {
		return children;
	}
	
}
