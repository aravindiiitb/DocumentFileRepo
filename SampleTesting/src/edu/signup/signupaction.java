package edu.signup;
import java.io.File;

import edu.dao.*;
import edu.classfile.User;

public class signupaction {

	private String email;
	private String password;
	private String pickUp;
	private String firstname;
	private String lastname;
	
	//private SignUpdao daoObj=new SignUpdao();
	public String execute()
	{
		 String message;
		 User user = new User();
		 user.setEmail(email);
		 user.setFirstname(firstname);
		 user.setLastname(lastname);
		 user.setPassword(password);
		 //message=daoObj.signUp(email,password);
		 
		 System.out.println(firstname + " " + lastname + " " + email + " " + password);
		 //System.out.println(user.getFirstname() + " " + user.getLastname()+ " " + user.getEmail() + " " + user.getPassword());
		 
		 CreateUser createUser = new CreateUser();
		 message = createUser.createUser(user);
		 new File("E:/6th Sem/Data Modelling/DocumentRepo/" + email).mkdir();
	     return message;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
}
