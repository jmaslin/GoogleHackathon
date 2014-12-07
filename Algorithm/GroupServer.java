/**
 * 
 */
package hackathon.google.nyc;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Cam
 *
 */

public class GroupServer {
	
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
	
}
