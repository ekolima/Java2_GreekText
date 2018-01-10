import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class inputFromTXTTest {

	private inputFromTXT iftxt;

	@Before
	public void initialise() {
		iftxt = new inputFromTXT();
	}

	@Test
	public void testGetChoice1() {
		int ch = iftxt.dialogueInput();
		Assert.assertEquals(ch, 1);
	}


}
