package com.comcast.genric.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {

	public String getDatafromJsonFile(String key) throws IOException, ParseException
	{
		FileReader fileR=new FileReader("./ConfigAppdata/data.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(fileR);
		
		JSONObject ob=(JSONObject) obj;
		String data = (String)ob.get(key);
		//System.out.println(BROWSER);
		return data;
		
	}
}
