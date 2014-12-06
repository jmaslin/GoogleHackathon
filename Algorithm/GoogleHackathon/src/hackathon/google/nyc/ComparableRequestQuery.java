/**
 * 
 */
package hackathon.google.nyc;

import java.awt.geom.Point2D;


/**
 * Query with comparable functionality to allow for a localization of services  
 * 
 * @author Cam
 */


public class ComparableRequestQuery implements Comparable<Object> {

	private String name;
	private String number;
	private String t;
	private String keyword; //possibly enum for simplification
	private Point2D.Double coord;
	private double distance; //units
	

	
	public ComparableRequestQuery(String t, String keyword,Point2D.Double coord, String name,String number){
		this.t = t;
		this.keyword = keyword;
		this.coord = coord;
		this.name = name;
		this.number = number;
	}
	
	/**
	 * @return Returns the location of a query as a String
	 */
	public Point2D.Double getLocation(){
		return coord;
	}
	
	/**
	 * @return Returns the type of the query as a Type enum
	 */
	public String getType(){
		return t;
	}
	
	/**
	 * Method to set the distance to a location
	 * 
	 * @param distance The new distance
	 */
	public void setDistance(double dist){
		distance = dist; 
	}
	
	/**
	 * Method to get the name
	 * 
	 * @return returns the name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Method to get the number
	 * 
	 * @return returns the number
	 */
	public String getNumber(){
		return number;
	}
	
	/**
	 * @return Returns the distance to the location in question
	 */
	public double getDistance(){
		return distance;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	
	/**
	 * Method to compare queries based on distance to request/service
	 * 
	 * @param other The query to which this one will be compared
	 */
	@Override
	public int compareTo(Object other) {
		double diff = distance - ((ComparableRequestQuery) other).getDistance();
		if(diff < 0) return -1;
		else if (diff > 0) return 1;
		else return 0;
	}

}
