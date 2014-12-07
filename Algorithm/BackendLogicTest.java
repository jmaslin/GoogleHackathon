package hackathon.google.nyc;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.security.InvalidKeyException;

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
		test.newQuery("2", "corn",coord,"Bob","9","9");
		coord = new Point2D.Double();
		coord.x = 5.1;
		coord.y = 4.9;
		test.newQuery("1", "maize",coord, "Jim","9","9");
		coord = new Point2D.Double();
		coord.x = 5;
		coord.y = 5;
		test.newQuery("2", "corn",coord,"Joe","9","9");
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
		test.newQuery("2", "maize",coord,"France","9","9");
		coord = new Point2D.Double();
		coord.x = 19;
		coord.y = 19;
		test.newQuery("1", "maize",coord,"Bo","9","9");
		
		
		
		
	}
	
	
}
