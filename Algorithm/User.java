/**
 * 
 */
package hackathon.google.nyc;

import java.util.ArrayList;

/**
 * @author Cam
 *
 */
public class User {
	
	private String name;
	private ArrayList<String> groups;
	private String number;
	
	/**
	 * @param name Name of the user
	 * @param number number of the user
	 */
	public User(String name, String number){
		this.name = name;
		this.number = number;
	}
	
	/**
	 * @param groupName name of group to add user to
	 */
	public void addToGroup(String groupName){
		groups.add(groupName);
	}
	
	/**
	 * @param groupName name of group to remove user from
	 */
	public void removeFromGroup(String groupName){
		groups.remove(groupName);
	}
	
	/**
	 * @return returns the names of the groups the user is in
	 */
	public ArrayList<String>  getGroups(){
		return groups;
	}
	
	/**
	 * @return returns the names of the user
	 * 
	 */
	public String  getName(){
		return name;
	}
	
}
