package ccl.v2.routine.impl.value.base;

import ccl.iface.debug.Logger;
import ccl.v2.routine.impl.value.ValueRepresentation;

public class CompiledNativeValue extends AbstractCompiledValue {

	public CompiledNativeValue(ValueRepresentation val) {
		super(val);
	}

	@Override
	protected String compileBase(String base) {
		Logger.out.log(this, "TODO: implement compileBase(String)");
		return "";
	}

	@Override
	protected String compileTodo(String todo) {
		Logger.out.log(this, "TODO: implement compileTodo(String)");
		return "";
	}

	@Override
	protected String beforeTodo(String todo) {
		Logger.out.log(this, "TODO: implement beforeTodo(String)");
		return "";
	}

	@Override
	protected String beforeBase(String base) {
		Logger.out.log(this, "TODO: implement beforeBase(String)");
		return "";
	}

}
