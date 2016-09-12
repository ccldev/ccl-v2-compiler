package ccl.v2.routine.impl.value.base;

import ccl.v2.routine.impl.value.CompiledValue;
import ccl.v2.routine.impl.value.ValueRepresentation;

public class CompiledNativeValue extends CompiledValue {

	private ValueRepresentation value;

	public CompiledNativeValue(ValueRepresentation val) {
		this.value = value;
		throw new RuntimeException("NI");
	}

}
