package edu.dao;

import edu.classfile.User;

import com.db4o.*;
import com.db4o.config.Configuration;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.config.FileConfiguration;
import com.db4o.internal.ObjectContainerFactory;
import com.db4o.io.PagingMemoryStorage;

public class CreateUser {
	
	

	public String createUser(User user) {
		//Create few student objects and store them in the database
		try{
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			EmbeddedObjectContainer db = Db4oEmbedded.openFile(config,"user.db4o");
			
		   	 db.store(user);
			 db.close();	 	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		  
		return "success";
	}
	
	public User checkUser(String email, String password) {
		try {
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			EmbeddedObjectContainer db = Db4oEmbedded.openFile(config,"user.db4o");
			User s = new User(null,null,email,password);
			ObjectSet result = db.queryByExample(s);
			System.out.println(result.toString());
			if(result.size() > 0){
				String[] vals = result.get(0).toString().split(" ");
				System.out.println(vals[0]);
				User u = new User(vals[0],vals[1],vals[2],vals[3]);
				db.close();
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
