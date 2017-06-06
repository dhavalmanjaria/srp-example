import java.util.Scanner;
import java.io.*;

/**
 * @author dhaval
 * Simple Book catalog that stores book name and author in CSV format.
 *
 */
public class Catalog {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Select option:");
		System.out.println("1: New Book");
		System.out.println("2: All Books");
		
		String filename = "books.json";
		
		int choice = 0;
		try {
			choice= scn.nextInt();
		}
		
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		
		JSONStorage storage = new JSONStorage();
		
		if (choice == 1) {
			InputParser input = new InputParser();
			Book newBook = input.getInput(System.in);
			storage.store(newBook, filename);
			
			System.out.println("Book Saved");
			return;
		}
		
		if (choice == 2) {
			storage.printAllBooks(filename);
		}

		scn.close();
	}
}
