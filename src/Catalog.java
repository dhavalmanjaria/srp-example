import java.util.Scanner;
import java.io.*;
/**
 * @author dhaval
 * Simple Book catalog that stores book name and author in CSV format.
 *
 */
public class Catalog {

	/**
	 * Reads name and author and stores in the file "books.txt" in CSV 
	 */
	void newBook() {
		String name = "", author = "";
		
		try(BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in))) {
		
			System.out.println("Name: ");
			name = reader.readLine();
			System.out.println("Author: ");
			author = reader.readLine();
		}

		catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		try(FileWriter out = new FileWriter("books.txt", true)) {
			out.write("\"" + name + "\",");
			out.write("\"" + author + "\"\n");
		}
		
		catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		System.out.println("Book saved.");
		
		return;
	}
	
	/**
	 * Parses the "books.txt" CSV file and prints all books
	 */
	void printBooks() {
		String file = "books.txt";
		
		String line = "";
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			while((line = br.readLine()) != null) {
				// use comma as separator
				String[] book = line.split(",");
				
				System.out.println("Name: " + book[0]);
				System.out.println("Author: " + book[1]);
				System.out.println();
			}
		}
		
		catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Select option:");
		System.out.println("1: New Book");
		System.out.println("2: All Books");
		
		int choice = 0;
		try {
			choice= scn.nextInt();
		}
		
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		
		
		if (choice == 1) {
			new Catalog().newBook();
		}
		
		if (choice == 2) {
			new Catalog().printBooks();
		}

		scn.close();
	}
}
