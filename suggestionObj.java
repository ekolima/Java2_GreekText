
public class suggestionObj {
	
	private String sugg;
	private int dist;

	public suggestionObj(int dist, String sugg){
		this.sugg = sugg;
		this.dist = dist;
	}

	public int getDist() {
		return dist;
	}

	public String getSugg() {
		return sugg;
	}

	public void setDist(int x) {
		this.dist = x;
	}

	public void setSugg(String x) {
		this.sugg = x;
	}
}
