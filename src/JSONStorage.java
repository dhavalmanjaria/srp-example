import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Store and retrieve books from JSON format.
 */
public class JSONStorage implements BookStorage {
	
	public void store(Book book, String filename) {
		Object obj = null;
		try {
			obj = new JSONParser().parse(new FileReader(filename));
		}
		
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		
		JSONArray data = (JSONArray)obj;
		
		if (data == null)
			data = new JSONArray();
		
		JSONObject bookObj = new JSONObject();
		bookObj.put("name", book.getName());
		bookObj.put("author", book.getAuthor());
		
		data.add(bookObj);
		
		try(FileWriter file = new FileWriter(filename)) {
			file.write(data.toJSONString());
			file.flush();
		}
		
		catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public void printAllBooks(String filename) {
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader(filename));
			
			JSONArray data = (JSONArray)obj;
			for(Object item: data.toArray()) {
				JSONObject jsonItem = (JSONObject)item;
				System.out.println("Name: " + jsonItem.get("name"));
				System.out.println("Author: " + jsonItem.get("author"));

				System.out.println();
			}
		}
		
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}