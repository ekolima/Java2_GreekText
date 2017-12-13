import java.util.*;

public class SpellMain {
	
	public static void main(String[] args) {
		//create dictionary
		ArrayList<String> dictionary= DictionaryGenerator.createDictionary();
		//create extra dictionary
		ArrayList<keyObject> extraDict = DictionaryGenerator.extraArrayList(dictionary);
		//create soundex dictionary
		ArrayList<String> dictSoundEx = DictionaryGenerator.createSoundExDictionary(dictionary);
		ArrayList<String> givenText = new ArrayList<String>();
		givenText = inputFromTXT.textInput();
		WordSearch.runWS(givenText, dictionary, extraDict, dictSoundEx); //soundExDict to be created!
	}
}
