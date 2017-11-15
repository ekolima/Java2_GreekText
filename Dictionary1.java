import java.util.HashMap;
import java.util.Map;
import java.io.FileRead;
import java.io.WriteFile;


public class Dictionary1 {

	public static void main(String[] args) {
	//dhmiourgia hash map
	map<String, String> stringCounts;

	String nextString;

	//import file/write file
	ofstream writeFile;
	ifstream File;

	//anoigma arxeiou gia na diavasei
	File.open("el_GRDict3.txt");

	if (File.is_open()) {
    	//diavasma leksis leksis

    	while (File >> nextString) {
        	//elegxos stiksis

        		for (int i = 0; i < nextString.length(); i++) {
            		if (nextString[i] == ',' || nextString[i] == '!' || nextString[i] == ';' || nextString[i] == '-' || nextString[i] == '.' || nextString[i] == '?' || nextString[i] == ':' || nextString[i] == '"' || nextString[i] == '(' || nextString[i] == ')' || nextString[i] == '_' || nextString[i] == '\'') {
                	nextString.erase(i, i);
                		i--;
            	}
        	}

        if (File.eof())
            break;
    }
}

//close current file
File.close();

//now print to an output file
writeFile.open("output.txt");

if (writeFile.is_open()) {
    System.out.println ("ITS OPEN AGAIN");

    //write size of map
    System.out.println("The size of the hash map is ");

    writeFile = stringCounts.size();
    //write all words in map

    //create iterator
    map<String, String>iterator i= stringCounts.begin();
    //iterate through map

   		while (i != stringCounts.end()) {
      	System.out.println("The key and value is : (" + i->first + "," + i->second + ")\n");
        i++;
    	}
	} else {

    return ("CANT OPEN\n");

	}

	}
}
