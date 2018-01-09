import java.io.*;
import java.util.*;

/**
 * @author Danay Kape
 * @author Eirini Kolimatsi
 *         <p>
 *         The {@code DictionaryGenerator} class asks the user to pick a
 *         language (Greek, English and Italian) and then generates for him or her a HashMap dictionary,
 *         based on which the spell check will be done.
 */
public class DictionaryGenerator {

	/**
	 * The {@code dictionary} method contains a dialogue with the user and prompts
	 * him to choose the language of the dictionary and the spellchecking process
	 * generally.
	 * 
	 * @return A HashMap that contains a dictionary in it.
	 */
	public static HashMap<Integer, String> dictionary() {
		String language;
		System.out.println("1 - Greek");
		System.out.println("2 - English");
		System.out.println("3 - Italian");
		System.out.println("0 - Exit");
		System.out.println("Choose text language, by entering its code as mentioned above: ");
		int languageChoice = WordSearch.getChoice(3);
		if (languageChoice == 1) {
			language = "el_GRDict4.txt";
		} else if (languageChoice == 2) {
			language = "en_ENDict.txt";
		} else if (languageChoice == 3) {
			language = "it_ITDict.txt";
		} else {
			language = null;
			System.out.println("-----------------------------------------");
			System.out.println("Thank you very much for using our software");
			System.out.println("-----------------------------------------");
			System.out.println("----- Development : Jarvellous.exe ------");
			System.out.println("-----------------------------------------");
			System.exit(0);
		}
		HashMap<Integer, String> dictionary = createHashMap(language);
		return dictionary;
	}

	/**
	 * The {@code createHashMap} method makes a connection between dictionary as txt
	 * and dictionary as a collection.
	 * <p>
	 * 
	 * @param fileName
	 *            File's name.
	 * @return a HashMap containing all the words of the given file.
	 */
	public static HashMap<Integer, String> createHashMap(String fileName) {
		HashMap<Integer, String> dictionary = new HashMap<Integer, String>();
		try {
			// when i = 0, the element with key =0 was null. This way it's ok.
			int i = -1;
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/".concat(fileName)), "ISO-8859-7"));
			String line;
			while ((line = reader.readLine()) != null) {
				i++;
				dictionary.put(i, line);
			}
			reader.close();
			return dictionary;
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", fileName);
			e.printStackTrace();
			return null;
		}
	}
}
