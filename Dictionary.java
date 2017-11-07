import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

    private HashMap<String, Sring> word;
    HashMap<String, String> wordlist = new HashMap<String, String>();
    String[] pinakas = new String[];
    String names;


    Dictionary() {

        // get user to enter word and  stoixeio pinaka
        Scanner scan = new Scanner(System.in);
        System.out.println("enter word ");
        words = scan.nextLine();

        System.out.println("enter stoixeio pinaka ");
        String pin = scan.nextLine();
        pinakas[] = String.parseInt(nums);
		//o pinakas tha apoteleitai apo ta stoixeia tou keimenou. to kathe stoixeio tou pinaka tha antistoixei se mia leksi tou keimenou.
        wordlist.put(word, pinakas[]);

        setWame(wordlist);

    }

    void printValue() {

        System.out.print(wordlist.get(words));

    }

    public HashMap<String, String> getWord() {
        return word;
    }

    public void setWord(HashMap<String, String> words) {
        this.word = words;
    }

    public static void main(String[] args) {

        Dictionary dic = new Dictionary();
        System.out.println(dic.getName());
        dic.printValue();


    }

}