package ccl.v2.routine.impl.value.base;

import ccl.v2.routine.impl.value.CompiledValue;
import ccl.v2.routine.impl.value.ValueRepresentation;

public abstract class AbstractCompiledValue extends CompiledValue{
	
	public AbstractCompiledValue(ValueRepresentation val){
		setCompiled(compileBase(val.getBaseValue()) + compileTodo(val.getTodo()));
		setBefore(beforeTodo(val.getTodo()) + beforeBase(val.getBaseValue()));
	}
	
	protected abstract String compileBase(String base);
	protected abstract String compileTodo(String todo);
	protected abstract String beforeTodo(String todo);
	protected abstract String beforeBase(String base);
	
}
