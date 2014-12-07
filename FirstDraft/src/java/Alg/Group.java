/**
 * 
 */
package hackathon.google.nyc;

import java.util.ArrayList;

import com.google.gson.Gson;

/**
 * @author Cam
 *
 */


public class Group {

	protected User theArchitect;
	protected String groupName;
        //store or group
       // private String type;
	protected ArrayList<User> usersList;
	protected ArrayList<String> tags;
	protected ArrayList<String> value;
        
        
	/**
	 * @param groupName Name of the group
	 * @param theArchitect User that created the group
	 * @param tags Tags associated with the group
         * @param chat chat history
	 */
	public Group(String groupName, User theArchitect, ArrayList<String> tags, ArrayList<String> value){
		this.groupName = groupName;
		this.theArchitect = theArchitect;
		this.tags = tags;
       this.value = value;
	}
	
    public void sendValue(String name, String message){
    	value.add(name + ": " + message);
    }
        
        
    public ArrayList<String> getValues(){
    	return value;
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
	public void subscribe(String name, String number, String email){
		User user = new User(name, number, email);
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
	
	public String getTagsJson(){
		return new Gson().toJson(tags);
	}
	
	public String getValueJson(){
		return new Gson().toJson(value);
	}
	
	public String getNamesJson(){
		ArrayList<String> names = new ArrayList<String>();
		for(User user : usersList){
			names.add(user.getName());
		}
		return new Gson().toJson(names);
	}
	
	/**
	 * @return returns the list of tags associated with this group
	 */
	public ArrayList<String> getTags(){
		return tags;
	}
        
        public ArrayList<String> getUserNames(){
            ArrayList<String> userNames = new ArrayList<String>();
            for (User e : usersList)
                userNames.add(e.getName());
            return userNames;
        }
        
        public ArrayList<User> getUsers(){
            return usersList;
        }
	public User getOwner(){
            return theArchitect;
        }
}
