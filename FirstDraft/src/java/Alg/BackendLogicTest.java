package hackathon.google.nyc;

import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.ArrayList;

public class BackendLogicTest {
	
	/**
	 * @param args
	 * @throws InvalidKeyException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InvalidKeyException, IOException { //Probably going away to main server system thing
		BackendDriver test = new BackendDriver();
		Point2D.Double coord = new Point2D.Double();
		coord.x = 1;
		coord.y = 1;
		test.newQuery("1", "corn",coord,"Bob","9","9");
		coord = new Point2D.Double();
		coord.x = 3;
		coord.y = 3;
		test.newQuery("1", "maize",coord, "Jim","9","9");
		coord = new Point2D.Double();
		coord.x = 5;
		coord.y = 5;
		test.newQuery("1", "corn",coord,"Joe","9","9");
		coord = new Point2D.Double();
		coord.x = 8;
		coord.y = 8;
		test.newQuery("1", "corn",coord,"Han Solo","9","9");
		coord = new Point2D.Double();
		coord.x = 10;
		coord.y = 10;
		test.newQuery("1", "corn",coord,"Sarah","9","9");
		coord = new Point2D.Double();
		coord.x = 10.2;
		coord.y = 10.2;
		test.newQuery("2", "maize",coord,"Mo","9","9");
		coord = new Point2D.Double();
		coord.x = 8.3;
		coord.y = 8.3;
		test.newQuery("2", "maize",coord,"Frank","9","9");
		coord = new Point2D.Double();
		coord.x = 19;
		coord.y = 19;
		test.newQuery("1", "maize",coord,"France","9","9");
		
		
		System.out.println(test.getJson());
		
		GroupServer server = new GroupServer();
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("test1");
		tags.add("test2");
		tags.add("test3");
		tags.add("test4");
		ArrayList<String> value = new ArrayList<String>();
		value.add("corn: 10");
		value.add("maize: 10");
		value.add("grain: 10");
		value.add("popcorn: 10");
		Shop shop = new Shop("first", new User("Frank Underwood", "123456789", "me@test.com"), tags, value, "shops");
		
		System.out.println(shop.getJson());
		
		
	}
	
	
}
