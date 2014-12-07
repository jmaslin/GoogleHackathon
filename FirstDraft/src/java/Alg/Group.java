/**
 * 
 */
package Alg;

import java.util.ArrayList;

/**
 * @author Cam
 *
 */


public class Group {

	private User theArchitect;
	private String groupName;
	private ArrayList<User> usersList;
	private ArrayList<String> tags;
	
	/**
	 * @param groupName Name of the group
	 * @param theArchitect User that created the group
	 * @param tags Tags associated with the group
	 */
	public Group(String groupName, User theArchitect, ArrayList<String> tags){
		this.groupName = groupName;
		this.theArchitect = theArchitect;
		this.tags = tags;
	}
	
	/**
	 * @param tag Tag to add to the group
	 */
	public void addTag(String tag){
		tags.add(tag);
	}
	
	/**
	 * @param multipleTags List of tags to add to the group
	 */
	public void addTags(ArrayList<String> multipleTags){
		for(String tag : multipleTags){
			tags.add(tag);
		}
	}
	
	/**
	 * @param tag tag to remove from the group's tag list
	 */
	public void removeTag(String tag){
		tags.remove(tag);
	}
	
	/**
	 * @param name name of the user to add to the group
	 * @param number number for the user being added to the group
	 */
	public void subscribe(String name, String number){
		User user = new User(name, number);
		subscribe(user);
	}
	
	/**
	 * @param newUser User to add to the group
	 */
	public void subscribe(User newUser){
		usersList.add(newUser);
		newUser.addToGroup(groupName);
	}
	
	/**
	 * @param oldUser User to remove from the group
	 */
	public void unsubscribe(User oldUser){
		usersList.remove(oldUser);
		oldUser.removeFromGroup(groupName);
	}
	
	/**
	 * @return returns the name of the group
	 */
	public String getName(){
		return groupName;
	}
	
	/**
	 * @return returns the list of tags associated with this group
	 */
	public ArrayList<String> getTags(){
		return tags;
	}
	
}
