import java.util.*;

public class WordSearch {

	static Scanner scan = new Scanner(System.in);

	// checks if a word exists and if not prints that word is not correct (after
	// checking every word)
	public static void textCheckRuntime(ArrayList<String> text, ArrayList<String> dict) {
		for (int i = 0; i < text.size(); i++) {
			String currentWord = text.get(i);
			if (!dict.contains(currentWord)) {
				System.out.printf("The word %s isn't spelled correctly!\n", currentWord);
			}
		}
	}

	// Asks the user to choose the basic options of this programme
	public static String dialogueWithUser() {
		System.out.println("Do you want to show suggestions for wrong words? Press 1 for yes and Press 0 for no");
		int answer;
		do {
			answer = scan.nextInt();
		} while (answer != 1 && answer != 0);
		return String.valueOf(answer);
	}

	public static void runWS(ArrayList<String> text, ArrayList<String> dict, ArrayList<keyObject> help,
			ArrayList<String> soundex_dict) {
		String choices = dialogueWithUser();
		if (choices.substring(1, 2).equals("1")) {
			int counter = 0;
			for (int i = 0; i < text.size(); i++) {
				if (!dict.contains(text.get(i))) {
					counter++;
					String result = Suggestions.runSuggestions(text.get(i), dict, help, soundex_dict);
					if (result != null) {
						text.remove(i);
						text.add(i, result);
					}
				}
			}
		} else {
			// Print each word separately
			textCheckRuntime(text, dict);
		}

	}

	public static void gradingTool(int mistakes, int total) {
		float result;
		result = mistakes / total * 100;
		System.out.printf("Your text's quality is %f", result);
		if (result == 100) {
			System.out.println("Excellent text! No mistakes.");
		} else if (result >= 90) {
			System.out.println("Very Good text! There where some mistakes.");
		} else if (result >= 80) {
			System.out.println("Quite Good text! Mistakes were existent.");
		} else if (result >= 70) {
			System.out.println("Good text! Many misatkes appeared.");
		} else if (result >= 50) {
			System.out.println("Not a good text! About half of the worlds were false.");
		} else if (result >= 25) {
			System.out.println("Bad text! Near no words were properly spelled.");
		} else {
			System.out.println("Extremely bad text! Possibly a language error occcured.");
		}
	}
}
