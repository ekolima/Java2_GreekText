import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 * @author Stelios Nikolos
 * @author Vasilis Panagopoulos
 * @author Eirini Kolimatsi
 *         <p>
 *         The class {@code inputFromTXT} gets user's input, in 2 possible ways:
 *         <p>
 *         1. From a text file, given its path.
 *         <p>
 *         2. From the terminal/cmd directly.
 */
public class inputFromTXT {

	/**
	 * The {@code dialogueInput} method asks the user to choose between inputing
	 * text through CMD and terminal. So, it returns 0, for input from file and 1
	 * for input from CMD.
	 * <p>
	 * 
	 * @return the user's choice of input method.
	 */
	public static int dialogueInput() {
		System.out.println("Choose way of giving your text:\n");
		System.out.println(" 0 - Input from file");
		System.out.println(" 1 - Input from terminal");
		System.out.println("");
		int choice = WordSearch.getChoice(1);
		return choice;
	}

	/**
	 * The {@code textInput} method based on user's choice reads words from
	 * indicated file or CMD and after removing everything that is now needed, such
	 * as symbols, returns them in an ArrayList.
	 * <p>
	 * 
	 * @param choice
	 *            an integer ranging from 0 to 1, indicating user's choice from
	 *            {@code dialogueInput} method
	 * @return an ArrayList containing all the words of the file or those inputed
	 *         from CMD
	 */
	public static ArrayList<String> textInput(int choice) {
		Scanner scan = new Scanner(System.in);
		String name;
		if (choice == 0) {
			System.out.println("Insert the path of txt file: \nFor example: src/TestFile.txt");
			name = scan.nextLine();
		} else {
			readCMD();
			name = "readFromCMD.txt";
		}

		ArrayList<String> words = new ArrayList<String>();

		try {
			Scanner fileIn = new Scanner(new File(name));
			int k = 0;
			while (fileIn.hasNext()) {
				words.add(k, fileIn.next());
				k++;
			}
			for (int i = 0; i < words.size(); i++) {
				for (int j = 0; j < words.get(i).length(); j++) {
					if (words.get(i).charAt(j) == '.') {
						words.set(i, words.get(i).replace(".", ""));
					} else if (words.get(i).charAt(j) == ',') {
						words.set(i, words.get(i).replace(",", ""));
					} else if (words.get(i).charAt(j) == '?') {
						words.set(i, words.get(i).replace("?", ""));
					} else if (words.get(i).charAt(j) == ':') {
						words.set(i, words.get(i).replace(":", ""));
					} else if (words.get(i).charAt(j) == '!') {
						words.set(i, words.get(i).replace("!", ""));
					} else if (words.get(i).charAt(j) == '(') {
						words.set(i, words.get(i).replace("(", ""));
					} else if (words.get(i).charAt(j) == ')') {
						words.set(i, words.get(i).replace(")", ""));
					} else if (words.get(i).charAt(j) == ';') {
						words.set(i, words.get(i).replace(";", ""));
					} else if (words.get(i).charAt(j) == '`') {
						words.set(i, words.get(i).replace("`", ""));
					} else if (words.get(i).charAt(j) == '~') {
						words.set(i, words.get(i).replace("~", ""));
					} else if (words.get(i).charAt(j) == '<') {
						words.set(i, words.get(i).replace("<", ""));
					} else if (words.get(i).charAt(j) == '>') {
						words.set(i, words.get(i).replace(">", ""));
					} else if (words.get(i).charAt(j) == '/') {
						words.set(i, words.get(i).replace("/", ""));
					} else if (words.get(i).charAt(j) == '|') {
						words.set(i, words.get(i).replace("|", ""));
					} else if (words.get(i).charAt(j) == '{') {
						words.set(i, words.get(i).replace("}", ""));
					} else if (words.get(i).charAt(j) == '[') {
						words.set(i, words.get(i).replace("[", ""));
					} else if (words.get(i).charAt(j) == ']') {
						words.set(i, words.get(i).replace("]", ""));
					} else if (words.get(i).charAt(j) == '+') {
						words.set(i, words.get(i).replace("+", ""));
					} else if (words.get(i).charAt(j) == '=') {
						words.set(i, words.get(i).replace("=", ""));
					} else if (words.get(i).charAt(j) == '-') {
						words.set(i, words.get(i).replace("-", ""));
					} else if (words.get(i).charAt(j) == '_') {
						words.set(i, words.get(i).replace("_", ""));
					} else if (words.get(i).charAt(j) == '*') {
						words.set(i, words.get(i).replace("*", ""));
					} else if (words.get(i).charAt(j) == '&') {
						words.set(i, words.get(i).replace("&", ""));
					} else if (words.get(i).charAt(j) == '@') {
						words.set(i, words.get(i).replace("@", ""));
					} else if (words.get(i).charAt(j) == '#') {
						words.set(i, words.get(i).replace("#", ""));
					} else if (words.get(i).charAt(j) == '$') {
						words.set(i, words.get(i).replace("$", ""));
					} else if (words.get(i).charAt(j) == '%') {
						words.set(i, words.get(i).replace("%", ""));
					} else if (words.get(i).charAt(j) == '^') {
						words.set(i, words.get(i).replace("^", ""));
					} else if (words.get(i).charAt(j) == ' ') {
						words.set(i, words.get(i).replace(" ", ""));
					}
				}
			}
			System.out.println("");
		} catch (FileNotFoundException e) {
			System.err.println("Exit because it was unable to open file");
			System.out.println("-----------------------------------------");
			System.out.println("Thank you very much for using our software");
			System.out.println("-----------------------------------------");
			System.out.println("----- Development : Jarvellous.exe ------");
			System.out.println("-----------------------------------------");
			System.exit(0);
		}
		return words;
	}

	/**
	 * The {@code readCMD} method lets the user input directly from CMD/Terminal.
	 * Although, the user should be aware that the maximum ability of continuous
	 * text (without using enter) is 559 characters or about 80-100 words.
	 */
	public static void readCMD() {
		final int bufferSize = 5024;
		final char[] buffer = new char[bufferSize];
		final StringBuilder out = new StringBuilder();
		Reader in = new InputStreamReader(System.in);
		try {
			System.out.println("Type or paste your data and hit Enter, Ctrl + D for Mac and Ctrl + Z for Windows.");
			PrintWriter writer = new PrintWriter("readFromCMD.txt", "ISO-8859-7");
			for (;;) {
				int rsz;
				try {
					rsz = in.read(buffer, 0, buffer.length);
					if (rsz < 0) {
						break;
					}
					out.append(buffer, 0, rsz);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			writer.println(out);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
