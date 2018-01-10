import static org.junit.Assert.*;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DictionaryGeneratorTest {

	private DictionaryGenerator digen;

	@Before
	public void initialise() {
		digen = new DictionaryGenerator();
	}

	@Test
	public void testDictionary() {
		HashMap<Integer, String> test = digen.createHashMap("test");
		HashMap<Integer, String> testHM = new HashMap<Integer, String>();
		testHM.put(0, "declare");
		testHM.put(1, "H");
		testHM.put(2, "the");
		testHM.put(3, "have");
		Assert.assertEquals(test, testHM);
	}
}
