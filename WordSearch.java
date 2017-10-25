import java.util.ArrayList;
import Dictionary;

public class WordSearch {

	public void textCheckRuntime(ArrayList<String> text) {
		for (int i = 0 ; i < text.size() ; i++) {
			String currentWord = text.get(i);
			boolean result = binarySearch(currentWord, Dictionary);
			if (result == false) {
				System.out.printf("The word %s isn't spelled correctly!\n", currentWord);
			}
		}
	}

	public ArrayList textCheckWithArray(ArrayList<String> text) {
		ArrayList<String> wrongWords = new ArrayList<String>();
		for (int i = 0 ; i < text.size() ; i++) {
			String currentWord = text.get(i);
			boolean result = binarySearch(currentWord, Dictionary);
			if (result == false) {
				wrongWords.add(currentWord);
			}
			return wrongWords;
		}
	}

	public void showWrongWords(ArrayList<String> wrongWords) {
		for (int i = 0 ; i < wrongWords.size() ; i++) {
			System.out.printf("The word %s isn't spelled properly!\n", wrongWords.get(i));
		}
	}

	public boolean binarySearch(String word, ArrayList<String> Dictionary) {
		boolean wordFound = false;
		int low = 0;
		int high = Dictionary.size() - 1;
		int mid = high / low;
		while (low <= high) {
			int compare = word.compareTo(Dictionary.get(mid));
			if (compare == 0) {
				wordFound=true;
				low = high + 1;
			} else if (compare < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return wordFound;
	}
}
