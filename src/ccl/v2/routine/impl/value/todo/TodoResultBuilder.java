package ccl.v2.routine.impl.value.todo;

import java.util.ArrayList;
import java.util.List;

import ccl.iface.debug.Logger;
import ccl.v2.routine.impl.value.CompiledValue;
import ccl.v2.routine.impl.value.ValueRepresentation;

public class TodoResultBuilder {
	
	private ArrayList<String> before;
	private ArrayList<String> first;
	private StringBuilder lastBuilder;
	
	public TodoResultBuilder(){
		lastBuilder = new StringBuilder();
		first = new ArrayList<>();
		before = new ArrayList<>();
	}
	
	public void append(TodoElement todoElement, int layer) {		
		Logger.err.log(this, todoElement + "");
		if(todoElement.getRaw().trim().length() == 0){
			if(todoElement.parent() != null){
				first.add(TodoType.INVOKE.getIdentifier(layer));
			}
			return;
		}
		try{
			TodoType type = todoElement.getDescription().getType();
			Logger.out.log(this, type + "");
			first.add(type.getIdentifier(layer));
			switch(type){
			case GET: lastBuilder.append(todoElement.getRaw().replaceAll("\\.", "|" + /*(char) + */layer)); break;
			default: throw new RuntimeException("Unexpected todo type " + type);
			}
			append(todoElement.getChildren().get(0), layer);
		}catch(UnknownTodoTypeException e){
			first.add(TodoType.INVOKE.getIdentifier(layer));
			CompiledValue[] values = makeValues(todoElement.getRaw(), layer + 1);
			for(int i = 0; i < values.length; i++){
				CompiledValue val = values[i];
				before.add(val.getBefore());
				lastBuilder.append(val.getCompiled());
			}
		}
	}

	private CompiledValue[] makeValues(String raw, int layer) {
		throw new RuntimeException("NI");
	}

	public TodoResult make() {
		Logger.out.log(this, first + "");
		TodoResult res = new TodoResult();
		res.setLast(lastBuilder.toString());
		res.setFirst(reverse(first));
		res.setBefore(reverse(before));
		return res;
	}

	private String reverse(List<String> list) {
		StringBuilder b = new StringBuilder();
		for(int i = list.size(); i >= 1; i--){
			int dex = i - 1;
			b.append(list.get(dex));
		}
		return b.toString();
	}

}
