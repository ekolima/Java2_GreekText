import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.*;

public class Wordstxt {
	public static void main(String str[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Insert name of txt file");
		String name = scan.nextLine();
		try {
			Scanner fileIn = new Scanner(new File("C:/Users/snikolos/Desktop/".concat(name)));
			ArrayList<String>  words = new ArrayList<String>();
			int k = 0;
			while (fileIn.hasNext()) {
				words.add(k, fileIn.next());
				k++;
			}
			for(int i = 0;i<words.size();i++) {
				for(int j = 0;j<words.get(i).length();j++) {
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
					}
				}
			}
			for(int x=0;x<words.size();x++) {
				System.out.print(" "+words.get(x));
			}
			System.out.println("");
		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file");
		}
	}
}