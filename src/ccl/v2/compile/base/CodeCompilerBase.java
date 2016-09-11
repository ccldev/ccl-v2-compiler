package ccl.v2.compile.base;

import ccl.v2.CclCompileException;
import ccl.v2.compile.categorize.CodeBlock;
import ccl.v2.compile.categorize.CodeSnippet;
import ccl.v2.read.CodePartReader;

public class CodeCompilerBase {

	public static String compileBlock(CodeBlock block) throws CclCompileException {
		block.getContent();
		CodePartReader reader = block.getContent().makeReader();
		throw new RuntimeException(reader + "");
	}

	public static String compileSnippet(CodeSnippet snippet) throws CclCompileException {
		throw new CclCompileException("NI");
	}

}
