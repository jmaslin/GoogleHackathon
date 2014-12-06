/**
 * 
 */
package hackathon.google.nyc;

import java.awt.geom.Point2D;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Cam
 *
 */
public class BackendDriver {

	ArrayList<HashMap<String, PriorityQueue<ComparableRequestQuery>>> list;
	double maxDist = 50; //Km
	
	public BackendDriver(){
		list = new ArrayList<HashMap<String, PriorityQueue<ComparableRequestQuery>>>();
		list.add(new HashMap<String, PriorityQueue<ComparableRequestQuery>>());
		list.add(new HashMap<String, PriorityQueue<ComparableRequestQuery>>());
	}
	
	/**
	 * Method to respond to a service or request
	 * 
	 * @param type The type of the query
	 * @param keyword The keyword of the query
	 * @param location The location of the query
	 * @param maxDist The max distance the querier is willing to respond
	 */
	public ComparableRequestQuery newQuery(String type, String keyword,Point2D.Double coord, String name) throws InvalidKeyException{
		ComparableRequestQuery rq = new ComparableRequestQuery(type,keyword,coord,name);
		ComparableRequestQuery foundQuery = null;
		
		int id = 0;
		int other = 1;
		switch(type){
		case "2": 			//service
			id = 1;
			other = 0;
			break;
		case "1":			//request
			id = 0;
			other = 1;
			break;
		default:
				throw new InvalidKeyException();
		}
		
		if(list.get(other).containsKey(keyword)){  //if opposite type is found			
			list.get(other).put(keyword, updateDistance(list.get(other).get(keyword),coord));			//update distances of other type
			if(list.get(other).get(keyword).peek().getDistance() <= maxDist){
				foundQuery = list.get(other).get(keyword).poll();
				System.out.println(foundQuery.toString() + ": " + name);
			} else {			
				doesntExist(rq, keyword, id);
			}
		}else {
			doesntExist(rq, keyword, id);

		}
		
		return foundQuery;
	}
	
	/**
	 * Method to add or create service or request that does not have immediate response
	 * 
	 * @param rq The query to be added
	 * @param keyword The keyword of the query
	 * @param id The type of the query
	 */
	private void doesntExist(ComparableRequestQuery rq, String keyword, int id){
		//System.out.println(rq.toString());
		if (list.get(id).get(keyword) != null){
			list.get(id).get(keyword).add(rq);
		}else {
			list.get(id).put(keyword,new PriorityQueue<ComparableRequestQuery>());
			list.get(id).get(keyword).add(rq);
		}
	}
	
	/**
	 * Method to parse through variables in priority queue and update a variable
	 * 
	 * @param location The new location that the distance will calculated from
	 */
	private PriorityQueue<ComparableRequestQuery> updateDistance(PriorityQueue<ComparableRequestQuery> pq, Point2D.Double coord){
		PriorityQueue<ComparableRequestQuery> newPQ = new PriorityQueue<ComparableRequestQuery>();
		
		ComparableRequestQuery rq = null;
		int size = pq.size();
	
		for(int i = 0; i < size; i ++){
				rq = pq.poll();
				rq.setDistance(calculateDistance(rq.getLocation(),coord));
				newPQ.add(rq);
		}
		return newPQ;
	}
	
	/**
	 * Method that calculates the distance between two locations
	 * 
	 * @param location1 The first location for distance calculation
	 * @param location2 The second location for distance calculation
	 *
	 *@return returns the distance between the two locations as a double in km
	 */
	private double calculateDistance(Point2D.Double coord1, Point2D.Double coord2){
		double lat1 = coord1.x;
		double lon1 = coord1.y;
		
		double lat2 = coord2.x;
		double lon2 = coord2.y;

		double R = 6371.0; // km
		double phi1 = lat1 * Math.PI / 180.0;
		double phi2 = lat2* Math.PI / 180.0;
		double deltaphi = (lat2-lat1)* Math.PI / 180.0;
		double deltalamda = (lon2-lon1)* Math.PI / 180.0;

		double a = Math.sin(deltaphi/2.0) * Math.sin(deltaphi/2.0) + Math.cos(phi1) * Math.cos(phi2) *  Math.sin(deltalamda/2.0) * Math.sin(deltalamda/2.0);
		double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0-a));

		double d = R * c;
		return d;
		}
	


}
