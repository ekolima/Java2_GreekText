import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Words {

	public static void main(String str[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Start writting your text");
		String keimeno = scan.nextLine();
		String pin[]=keimeno.split(" ");
		ArrayList<String>  words = new ArrayList<String>();
		for(int i = 0;i<pin.length;i++) {
			for(int j = 0;j<pin[i].length();j++) {

				if (pin[i].charAt(j) == '.') {
					pin[i] = pin[i].replace(".", "");
				} else if (pin[i].charAt(j) == ',') {
					pin[i] = pin[i].replace(",", "");
				} else if (pin[i].charAt(j) == '?') {
					pin[i] = pin[i].replace("?", "");
				} else if (pin[i].charAt(j) == ':') {
					pin[i] = pin[i].replace(":", "");
				} else if (pin[i].charAt(j) == '!') {
					pin[i] = pin[i].replace("!", "");
				} else if (pin[i].charAt(j) == '(') {
					pin[i] = pin[i].replace("(", "");
				} else if (pin[i].charAt(j) == ')') {
					pin[i] = pin[i].replace(")", "");
				}
			}
		}
		for(int i=0;i<pin.length;i++) {
			words.add(i, pin[i]);
		}
		for(int x=0;x<words.size();x++) {
			System.out.print(" "+words.get(x));
		}
		System.out.println("");
	}
}
