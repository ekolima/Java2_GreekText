import java.util.*;

public class Suggestions {

	static Scanner scan = new Scanner(System.in);

	public static String runSuggestions(String word, ArrayList<String> dict, ArrayList<keyObject> help, ArrayList<String> soundex_dict) {
		String result = null;
		ArrayList<suggestionObj> suggs = suggest(dict, word, help, soundex_dict);
		result = toString(suggs, word);
		return result;
	}

	public static String toString(ArrayList<suggestionObj> suggestions, String word) {
		System.out.printf("The word %s is not in the Dictionary.\n", word);
		System.out.printf("Do you mean:");
		for (int i = 0; i < suggestions.size(); i++) {
			System.out.printf("%d - %s\n", i + 1, suggestions.get(i).getSugg());
		}
		System.out.println(
				"If a choice is suitable for you and you want to change that word please select the proper number from the menu.");
		int choice = scan.nextInt();
		return suggestions.get(choice).getSugg();
	}

	public static ArrayList<suggestionObj> suggest(ArrayList<String> dict, String word, ArrayList<keyObject> help, ArrayList<String> soundex_dict) {
		ArrayList<suggestionObj> result = new ArrayList<suggestionObj>();
		ArrayList<suggestionObj> check1 = searchFor2FL(word, dict, help, soundex_dict);
		int res = 0;
		if (!check1.isEmpty()) {
			for (int i = 0; i < check1.size(); i++) {
				if (check1.get(i).getDist() <= word.length() * 0.25) {
					res = 1;
				}
			}
			if (res == 1) {
				result = check1;
			} else {
				ArrayList<suggestionObj> check2 = checkFromTheSameLetter(dict, word, soundex_dict);
				if (!check2.isEmpty()) {
					for (int i = 0; i < check2.size(); i++) {
						if (check2.get(i).getDist() <= word.length() * 0.25) {
							res = 1;
						}
					}
					if (res == 1) {
						result = check2;
					} else {
						check1.removeAll(check2);
						check1.addAll(check2);
						ArrayList<suggestionObj> check3 = checkFromTheSameLetter(dict, word, soundex_dict);
						if (!check3.isEmpty()) {
							for (int i = 0; i < check3.size(); i++) {
								if (check3.get(i).getDist() <= word.length() * 0.25) {
									res = 1;
								}
							}
							if (res == 1) {
								result = check3;
							} else {
								check1.removeAll(check3);
								check1.addAll(check3);
								result = check1;
							}
						}
					}
				}
			}
		}
		return result;
	}

	public static int distanceFound(String s1, String s2) {
		int distance = 0;
		int letter_result;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.substring(i, i + 1).equals(s2.substring(i, i + 1))) {
				letter_result = 0;
			} else {
				letter_result = 1;
			}
			distance = distance + letter_result;
		}
		return distance;
	}

	public static int backFront(String word, String dict_word) {
		int y;
		int count = 0;
		if (word.length() < dict_word.length()) {
			y = word.length();
		} else {
			y = dict_word.length();
			for (int i = 0; i < y; i++) {
				if (word.substring(i, i + 1) == dict_word.substring(i, i + 1)) {
					count++;
				} else {
					break;
				}
			}
		}
		for (int i = y - 1; i >= 0; i--) {
			if (word.substring(i, i + 1) == dict_word.substring(i, i + 1)) {
				count++;
			} else {
				break;
			}
		}
		int maxdistance = y - count;
		return maxdistance;
	}

	public static String SoundExAlgorithm(String word) {
		String newword = new String(word);
		StringBuffer buffer = new StringBuffer(newword);
		for (int i = 0; i < word.length(); i++) {
			if (word.substring(i, i + 1) == "ά")
				buffer.replace(i, i + 1, "α");
			else if (word.substring(i, i + 1) == "έ")
				buffer.replace(i, i + 1, "ε");
			else if (word.substring(i, i + 1) == "ό")
				buffer.replace(i, i + 1, "ο");
			else if (word.substring(i, i + 1) == "ώ")
				buffer.replace(i, i + 1, "ω");
			else if (word.substring(i, i + 1) == "ί" || word.substring(i, i + 1) == "ϊ")
				buffer.replace(i, i + 1, "ι");
			else if (word.substring(i, i + 1) == "ή")
				buffer.replace(i, i + 1, "η");
			else if (word.substring(i, i + 1) == "ύ" || word.substring(i, i + 1) == "ϋ")
				buffer.replace(i, i + 1, "υ");
			else if (word.substring(i, i + 1) == "ς")
				buffer.replace(i, i + 1, "σ");

			if (word.substring(i, i + 1) == "η" || word.substring(i, i + 1) == "υ")
				buffer.replace(i, i + 1, "ι");
			else if (word.substring(i, i + 1) == "ω")
				buffer.replace(i, i + 1, "ο");

			if (i < word.length() - 1) {
				if (word.substring(i, i + 2) == "γκ")
					buffer.replace(i, i + 2, "γγ");
				else if (word.substring(i) == word.substring(i + 1))
					buffer.delete(i, i + 1);

				if (word.substring(i, i + 1) == "ε" || word.substring(i) == "o" && word.substring(i + 1, i + 2) == "ι")
					buffer.replace(i, i + 2, "ι");
				else if (word.substring(i, i + 1) == "α" && word.substring(i + 1, i + 2) == "ι")
					buffer.replace(i, i + 2, "ε");
				else if (word.substring(i, i + 1) == "ε"
						|| word.substring(i, i + 1) == "α" && word.substring(i + 1, i + 2) == "υ")
					buffer.replace(i + 1, i + 2, "φ");
			}
		}
		return newword;
	}

	public static int indexOfSame2fl(ArrayList<keyObject> help, String word) {
		int res = -1;
		for (int i = 0; i < help.size(); i++) {
			if (word.equals(help.get(i).getFirst2Letters())) {
				res = i;
			}
		}
		return res;
	}

	public static ArrayList<suggestionObj> lastWayToLookUpForAWord(ArrayList<String> dict, String word, ArrayList<String> soundex_dict) {
		ArrayList<suggestionObj> result = new ArrayList<suggestionObj>();
		for (int i = 0; i < dict.size(); i++) {
			if (!dict.get(i).substring(0, 1).equals(word.substring(0, 1))) {
				int cd = calculateDistance(word, dict.get(i), soundex_dict.get(i));
				if (cd < word.length() * 0.5) {
					result.add(new suggestionObj(cd, dict.get(i)));
				}
			}
		}
		return result;
	}

	public static ArrayList<suggestionObj> checkFromTheSameLetter(ArrayList<String> dict, String word, ArrayList<String> soundex_dict) {
		ArrayList<suggestionObj> result = new ArrayList<suggestionObj>();
		int begin = dict.indexOf(word.substring(0, 1));
		int end = dict.indexOf(alphabetEncoded(word.substring(0, 1)));
		for (int i = begin; i <= end; i++) {
			if (dict.get(i).substring(0, 2) != word.substring(0, 2)) {
				int cd = calculateDistance(word, dict.get(i), soundex_dict.get(i));
				if (cd < word.length() * 0.5) {
					result.add(new suggestionObj(cd, dict.get(i)));
				}
			}
		}
		return result;
	}

	public static String alphabetEncoded(String x) {
		String encodedLetter;
		String nextLetter = null;
		switch (x) {
		case "α":
			nextLetter = "β";
			break;
		case "ά":
			nextLetter = "β";
			break;
		case "β":
			nextLetter = "γ";
			break;
		case "γ":
			nextLetter = "δ";
			break;
		case "δ":
			nextLetter = "ε";
			break;
		case "ε":
			nextLetter = "ζ";
			break;
		case "έ":
			nextLetter = "ζ";
			break;
		case "ζ":
			nextLetter = "η";
			break;
		case "η":
			nextLetter = "θ";
			break;
		case "ή":
			nextLetter = "θ";
			break;
		case "θ":
			nextLetter = "ι";
			break;
		case "ι":
			nextLetter = "κ";
			break;
		case "ϊ":
			nextLetter = "κ";
			break;
		case "ΐ":
			nextLetter = "κ";
			break;
		case "ί":
			nextLetter = "κ";
			break;
		case "κ":
			nextLetter = "λ";
			break;
		case "λ":
			nextLetter = "μ";
			break;
		case "μ":
			nextLetter = "ν";
			break;
		case "ν":
			nextLetter = "ξ";
			break;
		case "ξ":
			nextLetter = "ο";
			break;
		case "ο":
			nextLetter = "π";
			break;
		case "ό":
			nextLetter = "π";
			break;
		case "π":
			nextLetter = "ρ";
			break;
		case "ρ":
			nextLetter = "σ";
			break;
		case "σ":
			nextLetter = "τ";
			break;
		case "τ":
			nextLetter = "υ";
			break;
		case "υ":
			nextLetter = "φ";
			break;
		case "ύ":
			nextLetter = "φ";
			break;
		case "φ":
			nextLetter = "χ";
			break;
		case "χ":
			nextLetter = "ψ";
			break;
		case "ψ":
			nextLetter = "ω";
			break;
		case "ω":
			nextLetter = null;
			break;
		case "ώ":
			nextLetter = null;
			break;
		}
		encodedLetter = nextLetter;
		return encodedLetter;
	}

	// Simple binary search for a word into a sorted HashMap
	public static ArrayList<suggestionObj> searchFor2FL(String word, ArrayList<String> d, ArrayList<keyObject> help, ArrayList<String> soundex_dict) {
		ArrayList<suggestionObj> result = new ArrayList<suggestionObj>();
		String f2l = word.substring(0, 2);
		if (indexOfSame2fl(help, f2l) >= 0) {
			int low = help.get(indexOfSame2fl(help, f2l)).getIndexBeg();
			int high = help.get(indexOfSame2fl(help, f2l)).getIndexEnd();
			// int mid = high / low;
			for (int i = low; i <= high; i++) {
				int cd = calculateDistance(word, d.get(i), soundex_dict.get(i));
				if (cd < word.length() * 0.5) {
					result.add(new suggestionObj(cd, d.get(i)));
				}
			}
		}
		return result;
	}

	public static int calculateDistance(String word, String dict_word, String soundex_word) {
		int dist;
		if (word.length() == dict_word.length()) {
			dist = distanceFound(word, dict_word);
			return dist;
		} else {
			dist = backFront(word, dict_word);
			if (dist > word.length() * 0.4) {
				dist = backFront(SoundExAlgorithm(word), soundex_word);
			}
		}
		return dist;
	}
}
