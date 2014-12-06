package hackathon.google.nyc;

import java.awt.geom.Point2D;
import java.security.InvalidKeyException;

public class BackendLogicTest {
	
	/**
	 * @param args
	 * @throws InvalidKeyException 
	 */
	public static void main(String[] args) throws InvalidKeyException { //Probably going away to main server system thing
		BackendDriver test = new BackendDriver();
		Point2D.Double coord = new Point2D.Double();
		coord.x = 1;
		coord.y = 1;
		test.newQuery("1", "BANANA",coord,"Bob");
		coord = new Point2D.Double();
		coord.x = 3;
		coord.y = 3;
		test.newQuery("1", "BANANA",coord, "Jim");
		coord = new Point2D.Double();
		coord.x = 5;
		coord.y = 5;
		test.newQuery("1", "BANANA",coord,"Joe");
		coord = new Point2D.Double();
		coord.x = 8;
		coord.y = 8;
		test.newQuery("1", "BANANA",coord,"Han Solo");
		coord = new Point2D.Double();
		coord.x = 10;
		coord.y = 10;
		test.newQuery("1", "BANANA",coord,"Sarah");
		coord = new Point2D.Double();
		coord.x = 10.2;
		coord.y = 10.2;
		test.newQuery("2", "BANANA",coord,"Mo");
		coord = new Point2D.Double();
		coord.x = 8.3;
		coord.y = 8.3;
		test.newQuery("2", "BANANA",coord,"Frank");
		coord = new Point2D.Double();
		coord.x = 19;
		coord.y = 19;
		test.newQuery("1", "BANANA",coord,"France");
		
		
		
		
	}
	
	
}
