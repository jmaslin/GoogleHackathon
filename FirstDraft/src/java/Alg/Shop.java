/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackathon.google.nyc;

import java.util.ArrayList;

import com.google.gson.Gson;


/**
 *
 * @author Xiaomao
 */
public class Shop extends Group{


    
    public Shop(String groupName, User theArchitect, ArrayList<String> tags, ArrayList<String> value, String type) {
        super(groupName, theArchitect, tags, value,type);
    }
    
    @Override
    /**
     * Only owner should be able to send a message to update inventory
     */
    public void sendValue(String name, String value){
    	if(name.equals(theArchitect.getName())){
    		getValues().add(value);
    	}
    }
    
    public String getJson(){
    	return new Gson().toJson(value);
    }
   
    
    
    
}
