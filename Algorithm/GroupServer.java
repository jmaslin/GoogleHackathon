/**
 * 
 */
package hackathon.google.nyc;

import java.util.ArrayList;
import java.util.HashMap;

<<<<<<< HEAD
=======
import javax.security.auth.login.CredentialNotFoundException;

>>>>>>> 068d4485faaa9d65c15015af711f0064ae25f2ac
/**
 * @author Cam
 *
 */

public class GroupServer {
	
<<<<<<< HEAD
=======
	private HashMap<String,User> userList;
>>>>>>> 068d4485faaa9d65c15015af711f0064ae25f2ac
	private HashMap<String,Group> groupList;
	private HashMap<String,ArrayList<String>> tagList;
	
	public GroupServer(){
		groupList = new HashMap<String,Group>();
		tagList = new HashMap<String,ArrayList<String>>();
	}
	
	/**
	 * @param group Group to add to the database
	 */
	public void addGroup(Group group){
		groupList.put(group.getName(), group);
		for(String tag: group.getTags()){
			if(!tagList.containsKey(tag)){
				ArrayList<String> list = new ArrayList<String>();
				list.add(group.getName());
				tagList.put(tag, list);
			}else {
				ArrayList<String> list = tagList.get(tag);
				list.add(group.getName());
				tagList.put(tag, list);
			}
		}
	}
	
	/**
	 * @param groupName Name of group to add to database
	 * @param theArchitect Creator of the database
	 * @param tags Tags associated with group
	 */
	public void addGroup(String groupName, User theArchitect, ArrayList<String> tags){
		Group group = new Group(groupName, theArchitect, tags);
		addGroup(group);
	}
	
	/**
	 * @param name Name of group to get
	 * @return returns the group with specified name
	 */
	public Group getGroup(String name){
		return groupList.get(name);
	}
	
	/**
	 * @param tag Tag used to sort groups
	 * @return returns the groups with the tag
	 */
	public ArrayList<String> getGroupsByTag(String tag){
		return tagList.get(tag);
	}
	
	/**
	 * @param name name of group to remove from database
	 */
	public void removeGroup(String name){
		Group group = groupList.remove(name);
		for(String tag: group.getTags()){
			tagList.get(tag).remove(group.getName());
		}
	}
	
<<<<<<< HEAD
=======
	/**
	 * @param user Its a user to add to the list
	 */
	public void createUser(User user){
		userList.put(user.getName(),user);
	}
	
	/**
	 * @param user Its a user to add to the list
	 */
	public void createUser(String name, String number){
		User user = new User(name, number);
		createUser(user);
	}
	
	/**
	 * @param user User to remove
	 */
	public void removeUser(User user){
		userList.remove(user.getName());
	}
	
	/**
	 * @param user User to get
	 * @return returns the user with specified name
	 */
	public User getUser(String name){
		return userList.get(name);
	}
	
	/**
	 * @return returns the all the users
	 */
	public HashMap<String,User> getAllUsers(){
		return userList;
	}
	
	/**
	 * @return returns the groups a user is in
	 */
	public ArrayList<String> getUserGroups(String name){
		return userList.get(name).getGroups();
	}
	
	
	
	
>>>>>>> 068d4485faaa9d65c15015af711f0064ae25f2ac
}
