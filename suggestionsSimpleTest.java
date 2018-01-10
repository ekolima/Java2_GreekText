import static org.junit.Assert.*;

import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class suggestionsSimpleTest {

	private suggestionsSimple susi;

	@Before
	public void initialise() {
		susi = new suggestionsSimple();
	}
	
	@Test
	public void testLevninstein1() {
		String s = "suffer";
		String t = "suffers";
		int dist = suggestionsSimple.Levinstein(s, t);
		Assert.assertEquals(dist, 1);
	}

	@Test
	public void testLevninstein2() {
		String s = "sufer";
		String t = "suffer";
		int dist = suggestionsSimple.Levinstein(s, t);
		Assert.assertEquals(dist, 1);
	}

	@Test
	public void testLevninstein3() {

		String s = "suffer";
		String t = "uffer";
		int dist = suggestionsSimple.Levinstein(s, t);
		Assert.assertEquals(dist, 1);
	}
	
	@Test
	public void testLevRun1() {
		String s = "suffur";
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(0, "suffer");
		hm.put(1, "suffers");
		hm.put(2, "suffered");
		hm.put(3, "sypply");
		hm.put(4, "xylophone");
		hm.put(5, "a");
		ArrayList<String> should = new ArrayList<String>();
		should.add("suffer");
		should.add("suffers");
		ArrayList<String> sugg = suggestionsSimple.LevRun(s,hm);
		Assert.assertEquals(sugg, should);
	}
}
