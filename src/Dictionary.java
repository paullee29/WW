import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

//WW - Question 1. 

/*this class uses filereader to read in a file, and will tell you if there is nothing in the file
 * if there is properly formatted text, it will put the correct values into a hashmap and print them out
 * the correct format should be "apple - a fruit, a tech company" within the text file
 */



public class Dictionary {
	

	static FileReader fr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dictionary dictionary = new Dictionary ();
		HashMap <String, String[]> hashmap;
		fr = dictionary.fileReader();
		hashmap = dictionary.hasher(fr);
		dictionary.printHashMap(hashmap);

	}
	
	//will prompt the user to read a file and if a file is not found, will keep trying to prompt the user for the correct name/path
	
	private FileReader fileReader () {
		
		System.out.println("What is the directory/name of the file (default is the project folder): ");
		Scanner sc = new Scanner(System.in);
		String fileLocation = sc.nextLine();
		try {
			fr = new FileReader (fileLocation);
		} catch (FileNotFoundException e) {
			System.err.println("Caught FileNotFoundException " + e.getMessage());
			fileReader();
		}
		sc.close();
		return fr;
	}
	
	//puts the file contents into a hashmap with the key value being the word and the definitions as a String array
	
	private HashMap <String, String[]> hasher (FileReader fr) {
		HashMap<String, String[]> hashmap = new HashMap <String, String[]> ();
		Scanner scfr = new Scanner (fr);
		if (scfr.hasNextLine()) {
				while (scfr.hasNextLine()) { 
				String[] line = scfr.nextLine().split(" - ");
				String[] definition= line[1].split(", ");
				hashmap.put(line[0], definition);
			}
		} else {
			System.out.println("Nothing in file");
		}
		
		scfr.close();

		return hashmap;
	}
	
	//prints the hashmaps and uses printArray to print the definitions which are placed into an array
	
	private void printHashMap (HashMap <String, String[]> hashmap) {

		for (String word : hashmap.keySet()) {
			System.out.println("Word: " + word);
			String [] definitions = hashmap.get(word);
			printArray(definitions);
		}
	
	}
	
	//prints the arrays
	
	static void printArray (String [] definitions) {
		int length = definitions.length;
		for (int i =0; i <length;i++) {
			System.out.println("Definition " + (i+1) + ": "+ definitions[i]);
		}
	}
	
	 

}
