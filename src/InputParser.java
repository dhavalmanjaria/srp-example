
import java.util.Scanner;
import java.io.*;

/**
 * Manage parsing inputs.
 */
public class InputParser {
	
	/**
	 * Prompts the user for input of name and author to create a Book.
	 * @param in InputStream to be used by the Scanner class.
	 * @return Book
	 */
	public Book getInput(InputStream in) {
		Scanner scn = new Scanner(in);
		
		String name = "", author = "";
		
		try {
			System.out.println("Enter name: ");
			name = scn.nextLine();
			System.out.println("Enter author: ");
			author = scn.nextLine();
			scn.close();	
		}
			
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	
		Book book = new Book();
		
		book.setName(name);
		book.setAuthor(author);
		return book;
	}
}
