package ccl.v2.routine.impl.value.todo;

import java.util.ArrayList;

import ccl.iface.debug.Logger;

public class TodoElements extends ArrayList<TodoElement>{
	
	private static final long serialVersionUID = -6378135168184486211L;
	
	private int depth = 0;
	private TodoElement current;
	private boolean unescape;
	
	public TodoElements(){
		current = TodoElement.make();
	}
	
	public void feed(char next){
		Logger.out.log(this, (char) next + " " + current);
		if(unescape){
			current.feed(next);
			unescape = false;
		}else if(next == '\\'){
			unescape = true;
		}else if(next == '('){
			depth++;
			current = current.child();
		}else if(next == ')'){
			depth--;
			current = current.parent();
			closeElement();
		}else{
			current.feed(next);
		}
	}

	private void closeElement() {
		if(depth == 0){
			if(!current.isEmpty()){
				add(current);
			}
		}
		current = current.child();
	}

	public TodoResult compile(int layer) {
		if(current != null){
			closeElement();
			current = null;
		}
		TodoResultBuilder resBuilder = new TodoResultBuilder();
		for(int i = 0; i < size(); i++){
			resBuilder.append(get(i), layer);
		}
		return resBuilder.make();
	}
	
}
