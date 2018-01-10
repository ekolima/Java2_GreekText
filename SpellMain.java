import java.util.*;

/**
 * @author Team Jarvellous.exe
 *         <p>
 *         The Spell Checker software gets text input from the user and has the
 *         ability to check for mistakes and propose suggestions for words with
 *         mistakes. It supports 3 languages:
 *         <p>
 *         - Greek
 *         <p>
 *         - Romanian
 *         <p>
 *         Moreover, it includes a grading tool, which actually helps user
 *         understand the quality of the given text.
 *         <p>
 *         <p>
 *         ---------------------------------------
 *         <p>
 *         The {@code SpellMain} class combines all the other classes, we have
 *         developed, to make the spell checker run.
 */
public class SpellMain {

	/**
	 * The {@code main} method is the only method of {@code SpellMain} class and is
	 * the heart of our programme, as it makes it produce results.
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("-----------------------------------------");
		System.out.println("------ Welcome to Spellchecker!!! -------");
		System.out.println("-----------------------------------------");
		System.out.println("------------ Step 1: Language -----------");
		System.out.println("-----------------------------------------");
		HashMap<Integer, String> dictionary = DictionaryGenerator.dictionary();
		ArrayList<String> givenText = new ArrayList<String>();
		System.out.println("-----------------------------------------");
		System.out.println("-------- Step 2: Input your text --------");
		System.out.println("-----------------------------------------");
		int choice = inputFromTXT.dialogueInput();
		givenText = inputFromTXT.textInput(choice);
		System.out.println("-----------------------------------------");
		System.out.println("-------- Step 3: Spelling Check ---------");
		System.out.println("-----------------------------------------");
		WordSearch.runWS(givenText, dictionary);
		System.out.println("-----------------------------------------");
		System.out.println("Thank you very much for using our software");
		System.out.println("-----------------------------------------");
		System.out.println("----- Development : Jarvellous.exe ------");
		System.out.println("-----------------------------------------");
	}
}
