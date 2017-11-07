import java.util.ArrayList;
import java.util.Scanner;

public class Suggestions {
	
	public void suggestions(ArrayList<String> Dictionary, String word) {
		
		ArrayList<String> samelength = new ArrayList<String>();

		for (int i = 0; i <= Dictionary.size(); i++) {
			String[] dword = Dictionary.get(i).split("");
			if (dword.length == word.length()) {
				samelength.add(Dictionary.get(i));
			}
		}

		int[] sameletters = new int[samelength.size()];
		String[] letters = new int [samelength.size()];
		String[] spelledword = word.split("");

		for (int i = 0; i <= samelength.size(); i++) {
			letters[i] = samelength.get(i).split("");
			sameletters[i] = 0;
			for (int j = 0; j <= letters.length; j++) {
				if (letters[i] == spelledword[i]) {
					sameletters[i]++;
				}
			}
		    if (sameletters[i] > 2/3 * letters.length) {
				return samelength.get(i);
			}
		}
		
		
		
		public void createUsersDictionary() {
			
		}
		
		public void addToDictionary() {
			
		}
}
