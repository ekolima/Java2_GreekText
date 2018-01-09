import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {

	private WordSearch wse;

	@Before
	public void initialise() {
		wse = new WordSearch();
	}

	@Test
	public void testGetChoice1() {
		int ch = wse.getChoice(3);
		Assert.assertEquals(ch, 2);
	}

	@Test
	public void testGetChoice2() {
		int ch = wse.getChoice(3);
		Assert.assertEquals(ch, 0);
	}

	@Test
	public void testDialogue() {
		String ch = wse.dialogueWithUser();
		Assert.assertEquals(ch, "0");
	}
}
