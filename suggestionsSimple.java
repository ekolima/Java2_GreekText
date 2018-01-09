import java.util.*;

/**
 * The {@code suggestionsSimple} class suggests in a simple way what may the
 * user means for the given words that weren't found in the dictionary.
 * <p>
 * 
 * @author Kaiti Thoma
 * @author Eirini Kolimatsi
 *
 */
public class suggestionsSimple {

	/**
	 * The {@code LevRun} method sets the limitations needed to find out if a word
	 * is similar to the that is mispelled and decide if it will be suggesterd as
	 * potential correction.
	 * <p>
	 * 
	 * @param word
	 *            a {@code String} that contains one word, given from user
	 * @param dictionary
	 *            a {@code HashMap} that contains the words of the dictionary that
	 *            will be used
	 * @return an {@code ArrayList} that includes the suggestions that are found for
	 *         the specific wrong word
	 */
	public static ArrayList<String> LevRun(String word, HashMap<Integer, String> dictionary) {
		ArrayList<String> suggestions = new ArrayList<String>();
		int dist;
		for (int i = 0; i < dictionary.size(); i++) {
				dist = Levinstein(dictionary.get(i), word);
			if (word.length() == 2) {
				if (dist <= 0.5 * word.length()) {
					suggestions.add(dictionary.get(i));
				}
			} else if (word.length() > 7) {
				if (dist <= 0.22 * word.length()) {
					suggestions.add(dictionary.get(i));
				}
			} else {
				if (dist <= 0.35 * word.length()) {
					suggestions.add(dictionary.get(i));
				}
			}
		}
		return suggestions;

	}

	/**
	 * The {@code minimum} method calculates and returns the minimum of 3 integer
	 * numbers.
	 * <p>
	 * 
	 * @param numberA
	 *            an {@code int} number
	 * @param numberB
	 *            an {@code int} number
	 * @param numberC
	 *            an {@code int} number
	 * @return the minimum of numberA, numberB and numberC
	 */
	private static int minimum(int numberA, int numberB, int numberC) {
		int min;

		min = numberA;
		if (numberB < min) {
			min = numberB;
		}
		if (numberC < min) {
			min = numberC;
		}
		return min;
	}

	/**
	 * The {@code Levinstein} method calculates and returns the distance between 2
	 * strings, according to Levinstein algorithm.
	 * <p>
	 * 
	 * @param s
	 *            a {@code String}
	 * @param t
	 *            a {@code String}
	 * @return the distance between {@code String} s and {@code String} t
	 */
	public static int Levinstein(String s, String t) {
		int dist[][];
		int lengthS = s.length();
		int lengthT = t.length();
		int i;
		int j;
		char ithChar;
		char jthChar;
		int levDist;

		if (lengthS == 0) {
			return lengthT;
		}
		if (lengthT == 0) {
			return lengthS;
		}

		dist = new int[lengthS + 1][lengthT + 1];
		for (i = 0; i <= lengthS; i++) {
			dist[i][0] = i;
		}
		for (j = 0; j <= lengthT; j++) {
			dist[0][j] = j;
		}
		for (i = 1; i <= lengthS; i++) {
			ithChar = s.charAt(i - 1);
			for (j = 1; j <= lengthT; j++) {

				jthChar = t.charAt(j - 1);

				if (ithChar == jthChar) {
					levDist = 0;
				} else {
					levDist = 1;
				}
				dist[i][j] = minimum(dist[i - 1][j] + 1, dist[i][j - 1] + 1, dist[i - 1][j - 1] + levDist);
			}
		}
		return dist[lengthS][lengthT];
	}
}
