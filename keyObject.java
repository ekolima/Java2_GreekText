public class keyObject {

	private int indexBeg;
	private int indexEnd;
	private String first2Letters;

	public keyObject(int indexBeg, int indexEnd, String first2Letters){
		this.indexBeg = indexBeg;
		this.indexEnd = indexEnd;
		this.first2Letters = first2Letters;
	}

	public int getIndexBeg() {
		return indexBeg;
	}

	public int getIndexEnd() {
		return indexEnd;
	}

	public String getFirst2Letters() {
		return first2Letters;
	}

	public void setIndexBeg(int x) {
		this.indexBeg = x;
	}

	public void setIndexEnd(int x) {
		this.indexEnd = x;
	}

	public void setFirst2Letters(String x) {
		this.first2Letters = x;
	}
}
