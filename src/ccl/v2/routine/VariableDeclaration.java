package ccl.v2.routine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ccl.v2.compile.base.CompileRoutine;
import ccl.v2.compile.categorize.CodeSnippet;
import ccl.v2.routine.impl.VariableInfo;
import ccl.v2.routine.impl.value.ValueRepresentation;

public class VariableDeclaration implements CompileRoutine{

	@Override
	public String call(CodeSnippet snippet) {
		System.out.println(snippet);
		Matcher m = Pattern.compile(getPattern()).matcher(snippet.getRaw());
		m.find();
		VariableInfo var = VariableInfo.make(m);
		ValueRepresentation val = ValueRepresentation.make(var.getValue());
		throw new RuntimeException(val + "");
	}

	@Override
	public String getPattern() {
		return "\\s*var\\s+([a-zA-Z0-9]*)\\s*=\\s*(.*)\\s*;";
	}

}
