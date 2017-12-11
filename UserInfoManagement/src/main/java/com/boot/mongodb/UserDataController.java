package com.boot.mongodb;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


@RestController
@RequestMapping("/UserProfiles")
public class UserDataController {
	
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String showData() {
		
		
		MongoClient mongoClient = new MongoClient();
		
		JSONArray jsonArray = new JSONArray();
		
		JSONObject json = new JSONObject();
		
		DB db= mongoClient.getDB("test");
		
		DBCollection dbc= db.getCollection("users");
		
		DBCursor dbcursor= dbc.find();
		
		for (DBObject dbObject : dbcursor) {
			jsonArray.put(dbObject);
		}
		
		return jsonArray.toString();  	
	}

	

}
