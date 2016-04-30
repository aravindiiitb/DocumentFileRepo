package edu.dao;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;

import edu.classfile.ProjectClass;
import edu.classfile.ProjectType;
import edu.classfile.User;

public class CreateProjectObject {

	public String createproject(ProjectClass project) {
		//Create few student objects and store them in the database
		try{
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			EmbeddedObjectContainer db = Db4oEmbedded.openFile(config,"projects.db4o");
			db.store(project);
			db.close();	 	
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return "success";
	}

	public ProjectType getProjectType(String projtype) {
		try {
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			EmbeddedObjectContainer db = Db4oEmbedded.openFile(config,"projecttypes.db4o");
			ProjectType p = new ProjectType(projtype,null,null);
			ObjectSet result =  db.queryByExample(p);

			if(result != null){
				ProjectType projTyp = (ProjectType) result.get(0);
				db.close();
				return projTyp;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String createProjType(ProjectType temp) {
		// TODO Auto-generated method stub
		try{
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			EmbeddedObjectContainer db = Db4oEmbedded.openFile(config,"projecttypes.db4o");

			db.store(temp);
			db.close();	 	
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return "success";
	}

	public ProjectType[] getAllProjTypes() {
		try {
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			EmbeddedObjectContainer db = Db4oEmbedded.openFile(config,"projecttypes.db4o");
			ProjectType f = new ProjectType(null,null,null);
			ObjectSet result = db.queryByExample(f);
			System.out.println(result.toString());
			System.out.println("size: " + result.size());
			ProjectType[] vals = new ProjectType[result.size()];
			if(result.size() > 0){
				for(int i =0;i<result.size();i++){
					vals[i] = (ProjectType) result.get(i);	
				}
				//System.out.println(vals[0].toString());
				db.close();

				return vals;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public ProjectClass[] getAllProjects(User user) {
		// TODO Auto-generated method stub
		try {
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			EmbeddedObjectContainer db = Db4oEmbedded.openFile(config,"projects.db4o");
			ProjectClass f = new ProjectClass(null,user,null,null,null,null,null);
			ObjectSet result = db.queryByExample(f);
			System.out.println(result.toString());
			System.out.println("size: " + result.size());
			ProjectClass[] vals = new ProjectClass[result.size()];
			if(result != null){

				for(int i =0;i<result.size();i++){
					vals[i] = (ProjectClass) result.get(i);	
				}
				db.close();
				return vals;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ProjectClass[] getAllProjectsInRepo() {
		// TODO Auto-generated method stub
		try {
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			EmbeddedObjectContainer db = Db4oEmbedded.openFile(config,"projects.db4o");
			ProjectClass f = new ProjectClass(null,null,null,"public",null,null,null);
			ObjectSet result = db.queryByExample(f);
			System.out.println(result.toString());
			System.out.println("size: " + result.size());
			ProjectClass[] vals = new ProjectClass[result.size()];
			if(result != null){

				for(int i =0;i<result.size();i++){
					vals[i] = (ProjectClass) result.get(i);	
				}
				db.close();
				return vals;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String removeProject(ProjectClass p) {
		// TODO Auto-generated method stub
		try{
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			EmbeddedObjectContainer db = Db4oEmbedded.openFile(config,"projects.db4o");
			ObjectSet result = db.queryByExample(p);
			if(result != null) {
				ProjectClass a = (ProjectClass) result.get(0);
				db.delete(a);
				db.close();
			}
			
			return "success";
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

}
