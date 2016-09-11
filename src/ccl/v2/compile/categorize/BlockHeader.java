package ccl.v2.compile.categorize;

public class BlockHeader {

	private String raw;

	public BlockHeader(String raw) {
		this.raw = raw;
		throw new RuntimeException(raw);
	}

	public String getRaw() {
		return raw;
	}

}
