package Alg;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;


public class JsonThesaurus {

	String link;
	JsonReader reader;
	URL website;
	ArrayList<String> output;
	
	
	public JsonThesaurus(){
		
	}
	
	public ArrayList<String> thesaurus(String keyword) throws IOException{
		website = new URL("http://words.bighugelabs.com/api/2/51881d2aa4584f77f495a7f512ccd784/"+keyword+"/json");
		output = new ArrayList<String>();
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream("information.html");
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		
		reader = new JsonReader(new FileReader("information.html"));
		reader.beginObject();
		
		reader.skipValue();
		reader.beginObject();
		
		reader.skipValue();
		reader.beginArray();
		
		
		
		while(reader.peek() != JsonToken.END_ARRAY){
			String str = reader.nextString();
			output.add(str);
		}
		reader.endArray();
		return output;
	}


	
	
	
}
