package edu.dao;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;

import edu.classfile.FileClass;
import edu.classfile.ProjectClass;
import edu.classfile.User;

public class FileUploadDAO {
	
	public String fileUpload(FileClass fileObj){
		try{
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			EmbeddedObjectContainer db = Db4oEmbedded.openFile(config,"files.db4o");
			db.store(fileObj);
			db.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}

	public FileClass[] getAllFiles(User user, ProjectClass proj) {
		// TODO Auto-generated method stub
		try {
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			EmbeddedObjectContainer db = Db4oEmbedded.openFile(config,"files.db4o");
			FileClass f = new FileClass(null,null,null,null,null,null,proj,user);
			ObjectSet result = db.queryByExample(f);
			System.out.println(result.toString());
			System.out.println("size: " + result.size());
			FileClass[] vals = new FileClass[result.size()];
			if(result.size() > 0) {
				
				for(int i =0;i<result.size();i++){
					vals[i] = (FileClass) result.get(i);	
				}
	
				db.close();
				return vals;
			}
			else{
				db.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/*public FileClass[] getAllusersFiles() {
		// TODO Auto-generated method stub
		try {
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			EmbeddedObjectContainer db = Db4oEmbedded.openFile(config,"files.db4o");
			FileClass f = new FileClass(null,null,null,null,null,null,0,null);
			ObjectSet result = db.queryByExample(f);
			System.out.println(result.toString());
			System.out.println("size: " + result.size());
			FileClass[] vals = new FileClass[result.size()];
			if(result.size() > 0){
				
				for(int i =0;i<result.size();i++){
					vals[i] = (FileClass) result.get(i);	
				}
				System.out.println(vals[0].toString());
				
				db.close();
				return vals;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}*/

}
