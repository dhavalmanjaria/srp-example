import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Store and retrieve books from JSON format.
 */
public class CSVStorage implements BookStorage {
	
	@Override
	public void printAllBooks(String filename) {
		String line = "";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
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
	
	@Override
	public void store(Book book, String filename) {
		
		try(FileWriter out = new FileWriter(filename, true)) {
			out.write("\"" + book.name + "\",");
			out.write("\"" + book.author + "\"\n");
			out.flush();
		}
		
		catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		System.out.println("Book saved.");
		
		return;		
	}
}
