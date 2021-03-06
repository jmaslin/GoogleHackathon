/**
 * 
 */
package Alg;

import java.util.ArrayList;

/**
 * @author Cam
 *
 */
public class User {
	
	private String name;
	private ArrayList<String> groups;
	private String number;
        private String email;
	
	/**
	 * @param name Name of the user
	 * @param number number of the user
	 */
	public User(String name, String number, String email){
		this.name = name;
		this.number = number;
                this.email = email;
	}
	
        public String getEmail(){
            return email;
        }
        
        public String getNumber(){
            return number;
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
	 */
	public String  getName(){
		return name;
	}
	

}
