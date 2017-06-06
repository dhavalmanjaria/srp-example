/**
 * Provides methods to store books in a file and print all the books.
 */
public interface BookStorage {
	/**
	 * Store a book in a file
	 * @param book the book to store
	 * @param filename name of the file to store books in
	 */
	void store(Book book, String filename);
	
	/**
	 * Print all books currently stored to stdout.
	 * @param filename name of the file to read from.
	 */
	void printAllBooks(String filename);
}
