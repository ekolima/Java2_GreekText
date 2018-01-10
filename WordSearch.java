import java.util.*;

/**
 * @author Team jarvellous.exe
 *         <p>
 *         The {@code WordSearch} class uses the {@code suggestionsSimple} in
 *         conjunction with the given text by the user to propose correction for
 *         the wrong words. Includes a grading tool for the text.
 */
public class WordSearch {

	static Scanner scan = new Scanner(System.in);

	/**
	 * The {@code dialogueWithUser} method asks the user to either press 1, if he
	 * wants to be shown suggestions for the wrong words, or 0, if he does not
	 * desire to be shown suggestions.
	 * <p>
	 * 
	 * @return the choice of the user, concerning the use or no of suggestions for
	 *         wrong words.
	 */
	public static String dialogueWithUser() {
		System.out.println("Do you want to show suggestions for wrong words? Press 1 for yes and Press 0 for no");
		int answer;
		do {
			answer = scan.nextInt();
		} while (answer != 1 && answer != 0);
		return String.valueOf(answer);
	}

	/**
	 * The {@code textCheckRuntime} checks all the words the user has given and
	 * prints the ones that are not correct, according to what the dictionary
	 * includes. Afterwards, prints the text quality through out tool,
	 * {@code gradingTool}.
	 * <p>
	 * 
	 * @param text
	 *            an ArrayList that contains the user's text
	 * @param dict
	 *            a HashMap that contains the generated dictionary
	 */
	public static void textCheckRuntime(ArrayList<String> text, HashMap<Integer, String> dict) {
		int mistakes = 0;
		for (int i = 0; i < text.size(); i++) {
			String currentWord = text.get(i).toLowerCase();
			if (!dict.containsValue(currentWord)) {
				if (!(dict.containsValue(currentWord.toLowerCase()) || dict.containsValue(currentWord.toUpperCase()))) {
					System.out.printf("The word %s isn't spelled correctly!\n", currentWord);
					mistakes++;
				}
			}
		}
		gradingTool(mistakes, text.size());
	}

	/**
	 * The {@code runWS} is the heart of the class {@code WordSearch}, as it makes
	 * it to combine all the other methods. How it works now: Firstly, calls
	 * {@code dialogueWithUser} method to get user's choice about suggestions. Then,
	 * in case the user wants to be shown suggestions, for all the mispelled words
	 * calls the {@code LevRun} method from {@code suggestionsSimple} class, to
	 * propose suggestions and after there is a dialogue for the user about
	 * accepting or not a suggestion. Finally, it enforces {@code gradingTool} .
	 * Otherwise, in case that the user does not prefer to be shown suggestions, the
	 * {@code checkRuntime} method is called.
	 * <p>
	 * 
	 * @param text
	 *            text an ArrayList that contains the user's text
	 * @param dict
	 *            a HashMap that contains the generated dictionary
	 */
	public static void runWS(ArrayList<String> text, HashMap<Integer, String> dict) {
		String choices = dialogueWithUser();
		if (choices.substring(0, 1).equals("1")) {
			int mistakes = 0;
			for (int i = 0; i < text.size(); i++) {
				// if the word isn't found in the dictionary
				String currentWord = text.get(i);
				if (!dict.containsValue(currentWord)) {
					if (!(dict.containsValue(currentWord.toLowerCase())
							|| dict.containsValue(currentWord.toUpperCase()))) {
						mistakes++;
						ArrayList<String> result = suggestionsSimple.LevRun(currentWord, dict);
						if (!result.isEmpty()) {
							System.out.println("-----------------------------------------");
							System.out.printf("The word %s may be wrong. ", currentWord);
							System.out.println(
									"If you mean any of the following words please insert its number. Ortherwise, press 0.");
							for (int j = 0; j < result.size(); j++) {
								System.out.printf("%d  -  %s\n", j + 1, result.get(j));
							}
							int userChoice = getChoice(result.size());
							if (userChoice != 0) {
								System.out.printf("%s\n", result.get(userChoice - 1));
								text.remove(i);
								text.add(i, result.get(userChoice - 1));
							}
						} else {
							System.out.printf("The word %s is wrong! No suggestions found!", currentWord);
						}

					}
				}
			}
			gradingTool(mistakes, text.size());
		} else {
			// Print each wrong word separately
			textCheckRuntime(text, dict);
		}
		//

	}

	/**
	 * The {@code getChoice} method gets an integer from the user and this is the
	 * upper acceptable limit of integers. So, what it makes is asking the user to
	 * enter an integer, and if not it continuously asks to do so until giving a
	 * valid option.
	 * <p>
	 * 
	 * @param upperLimit
	 *            the highest acceptable number of integers
	 * @return the final choice of the user
	 */
	public static int getChoice(int upperLimit) {
		while (true) {
			try {
				System.out.println("Enter choice: ");
				int userChoice = scan.nextInt();
				if (userChoice >= 0 && userChoice <= upperLimit) {
					return userChoice;
				} else {
					System.out.println("Invalid choice. Try again: ");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input");
			}
			scan.nextLine();
		}
	}

	/**
	 * The {@code gradingTool} method is a toll that shows the quality of the given
	 * text, in terms of spelling errors.
	 * <p>
	 * 
	 * @param mistakes
	 *            an integer, indicating the number of wrong words on the given text
	 * @param total
	 *            an integer, indicating the total number of words that the user
	 *            gave
	 */
	public static void gradingTool(int mistakes, int total) {

		System.out.println("");
		System.out.println("-----------------------------------------");
		Float result;
		result = (float) (total - mistakes) / total * 100;

		String temp = ("Your text's quality is ") + result;

		if (result == 100) {

			System.out.printf("%s / 100.0\nExcellent text! No mistakes.\n", temp);

		} else if (result >= 90 && result < 100) {

			System.out.printf("%s / 100.0\nVery Good text! There were some mistakes.\n", temp);

		} else if (result >= 80 && result < 90) {

			System.out.printf("%s / 100.0\nQuite Good text! Mistakes were existent.\n", temp);

		} else if (result >= 70 && result < 80) {

			System.out.printf("%s / 100.0\nGood text! Many mistakes appeared.\n", temp);

		} else if (result >= 50 && result < 70) {

			System.out.printf("%s / 100.0\nNot a good text! About half of the worlds were wrong.\n", temp);

		} else if (result >= 25 && result < 50) {

			System.out.printf("%s / 100.0\nBad text! Near no words were properly spelled.\n", temp);

		} else {

			System.out.printf("%s / 100.0\nExtremely bad text! Possibly a language error occcured.\n", temp);

		}

	}
}
