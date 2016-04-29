package edu.signup;

import edu.classfile.FileClass;
import edu.classfile.ProjectClass;
import edu.classfile.ProjectType;
import edu.classfile.User;
import edu.dao.CreateProjectObject;
import edu.dao.CreateUser;
import edu.dao.FileUploadDAO;
import edu.util.DMsession;

public class LoginAction extends DMsession {
	
	private String email;
	private String password;
	private String baseURL;  
	
	public String execute(){
		FileUploadDAO fileUploadDAO = new FileUploadDAO();
		
		CreateUser createUser = new CreateUser();
		System.out.println(email + " " + password);
		
		User usr = createUser.checkUser(email,password);
		
		CreateProjectObject obj = new CreateProjectObject();
		ProjectType[] allTypes = obj.getAllProjTypes();
		ProjectClass[] proj = obj.getAllProjects(usr);
		
		sessionMap.put("user",usr);
		sessionMap.put("allTypes", allTypes);
		sessionMap.put("allProj", proj);
		
		if(email.equals("admin@filerepo.com") && password.equals("12345")){
			System.out.println("in admin :P ");
			System.out.println("in admin :P thing");
			
			return "admin";
		}
		
		
		
		if(usr != null){
			
			return "success";
		}
		return "failure";
	}
	
	public String logout(){
		if(sessionMap != null){
			sessionMap.clear();
		}		
		baseURL = "http://localhost:8080/SampleTesting/";
		System.out.println(sessionMap.size());
		return "success";
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}	

}
