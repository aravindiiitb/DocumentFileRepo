package edu.signup;

import java.util.ArrayList;

import edu.classfile.ProjectType;
import edu.dao.CreateProjectObject;
import edu.util.DMsession;

public class CreateProjectType extends DMsession {

	String projtype;
	String projdesc;
	String[] projlifestages;
	
	public String createProjectType() {
		System.out.println("lifestages: " + projlifestages[0]);
		System.out.println("lifestages: " + projlifestages[1]);
		
		ProjectType temp = new ProjectType(projtype,projdesc,projlifestages);
		CreateProjectObject createObj = new CreateProjectObject();
		String message = createObj.createProjType(temp);
		
		return message;
		
	}

	public String getProjtype() {
		return projtype;
	}

	public void setProjtype(String projtype) {
		this.projtype = projtype;
	}

	public String getProjdesc() {
		return projdesc;
	}

	public void setProjdesc(String projdesc) {
		this.projdesc = projdesc;
	}

	public String[] getProjlifestages() {
		return projlifestages;
	}

	public void setProjlifestages(String[] projlifestages) {
		this.projlifestages = projlifestages;
	}
	
}
