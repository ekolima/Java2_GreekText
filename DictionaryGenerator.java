import java.io.*;
import java.util.*;
import java.nio.file.Paths;

public class DictionaryGenerator {
	private static Scanner input;

	/*public static HashMap<keyObject, String> createDictionary() {
		openFile();
		HashMap<keyObject, String>  shm = new HashMap<keyObject, String>();
		readWords(shm);
		closeFile();
		return shm;
	}*/

	public static ArrayList<String> createDictionary() {
		openFile();
		ArrayList<String>  shm = new ArrayList<String>();
		readWords(shm);
		closeFile();
		return shm;
	}

	public static ArrayList<String> createSoundExDictionary(ArrayList<String> a) {
		ArrayList<String> als = new ArrayList<String>();
		for (int i = 0 ; i < a.size() ; i++) {
			als.add(Suggestions.SoundExAlgorithm(a.get(i)));
		}
		return als;
	}

	public static ArrayList<keyObject> extraArrayList(ArrayList<String> d){
		ArrayList<keyObject> al = new ArrayList<keyObject>();
		//run for all the dictionary
		for (int i = 0 ; i < d.size() ; i++) {
			//if the word has at least 2 letters
			if (d.get(i).length() > 1) {
				//if there is something in the array list
				if (!al.isEmpty()) {
					//if the first 2 letters of the current word are different than those of the previous one
					if (al.get(al.size()-1).getFirst2Letters() != d.get(i).substring(0,2)) {
						al.get(al.size()-1).setIndexEnd(i-1);
						al.add(new keyObject(i, 0, d.get(i).substring(0,2)));
					}
				//if the array list is empty
				} else {
					al.add(new keyObject(0, 0, d.get(i).substring(0,2)));
				}
			//is the dictionary entry is just a letter
			} else {
				al.add(new keyObject(i, i, d.get(i)));
			}
		}
		return al;
	}

	public static void openFile() {
		try {
			input = new Scanner(Paths.get("el_GRDict3.txt"));
		} catch (IOException e){
			System.out.println("Error occured while opening the file. Terminating.");
			System.exit(1);
		}
	}

	public static void readWords(ArrayList<String> h) {
		try {
			while (input.hasNext()) {
				String b = input.nextLine();
				h.add(b);
			}
		} catch (NoSuchElementException e) {
			System.err.println("File improperly formed. Terminating.");
		} catch (IllegalStateException e) {
			System.err.println("Error while reading from the file. Terminating.");
		}
	}

	public static void closeFile(){
		if (input != null) {
			input.close();
		}
	}
}
