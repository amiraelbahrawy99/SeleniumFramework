package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	
	public String firstName,lastName,email,password;
	
	
	
	public void JSONDataReader() throws IOException, ParseException
	{
		
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\registerData.json";
		File srcFile=new File(filePath);
		FileReader reader=new FileReader(srcFile);
		JSONParser parser=new JSONParser();
		JSONArray jArray=(JSONArray) parser.parse(reader);
		
		for(Object jsonObj : jArray)
		{
			JSONObject person=(JSONObject) jsonObj;
			firstName=(String) person.get("firstname");
			System.out.println(firstName);
			
			lastName=(String) person.get("lastName");
			System.out.println(lastName);

			email=(String) person.get("email");
			System.out.println(email);
			
			password=(String) person.get("password");
			System.out.println(password);
			
			
		}
		
	}
	

}
