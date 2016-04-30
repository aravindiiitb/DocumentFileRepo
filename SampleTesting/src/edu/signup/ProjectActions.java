package edu.signup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.classfile.FileClass;
import edu.classfile.ProjectClass;
import edu.classfile.ProjectType;
import edu.classfile.User;
import edu.dao.CreateProjectObject;
import edu.dao.FileUploadDAO;
import edu.util.DMsession;

public class ProjectActions extends DMsession {

	String projname;
	String projdesc;
	String projtags;
	String projtype;
	String visibility;
	
	String clickedIndex; //to retrieve proj details
	String clickedOn;
	private String clickedR;
	public String getClickedR() {
		return clickedR;
	}

	public void setClickedR(String clickedR) {
		this.clickedR = clickedR;
	}

	public String getClickedOn() {
		return clickedOn;
	}

	public void setClickedOn(String clickedOn) {
		this.clickedOn = clickedOn;
	}

	public String getClickedIndex() {
		return clickedIndex;
	}

	public void setClickedIndex(String clickedIndex) {
		this.clickedIndex = clickedIndex;
	}

	public String createProject() {
		User user = (User) sessionMap.get("user");
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
		
		System.out.println("Proj desc: "+projdesc);
		CreateProjectObject projObj = new CreateProjectObject();
		ProjectType projTyp = projObj.getProjectType(projtype);
		ProjectClass tempProjObj = new ProjectClass(projname, user, projTyp, visibility, projdesc, df.format(dateobj), projtags);
		String message = projObj.createproject(tempProjObj);
		ProjectClass[] proj = projObj.getAllProjects(user);

		sessionMap.put("allProj", proj);
		
		return message;
		
	}
	
	public String getProjectDetails() {
		sessionMap.put("clickedIndex", clickedIndex);
		System.out.println("clicked index: " + clickedIndex);
		ProjectClass[] p = (ProjectClass[]) sessionMap.get("allProj");
		User user = (User) sessionMap.get("user");

		ProjectClass temp = p[Integer.parseInt(clickedIndex)];
		/*Getting all the files which has this projectClass*/
		FileUploadDAO fileDAOobj = new FileUploadDAO();
		FileClass[] files = fileDAOobj.getAllFiles(user,temp);
		
		sessionMap.put("allFiles",files);
		return "success";
	}
	public String getAllProjects() {
		CreateProjectObject obj = new CreateProjectObject();
		ProjectClass[] allRepoProj =  obj.getAllProjectsInRepo();
		sessionMap.put("allRepoProj", allRepoProj);
		return "success";
	}
	public String setDownloadFileIndex() {
		System.out.println("Clicked on download: " + clickedOn);
		
		FileClass[] f = (FileClass[]) sessionMap.get("allFiles");
		FileClass dwnFle = f[Integer.parseInt(clickedOn)];
		sessionMap.put("downloadFile", dwnFle);
		return "success";
	}
	
	public String removeProject() {
		System.out.println("clickedR: " + clickedR);
		CreateProjectObject obj = new CreateProjectObject();
		ProjectClass[] allRepoProj =  (ProjectClass[]) sessionMap.get("allProj");
		ProjectClass p = allRepoProj[Integer.parseInt(clickedR)];
		if(obj.removeProject(p) != null) {
			User user = (User) sessionMap.get("user");
			ProjectClass[] allProj = obj.getAllProjects(user);
			sessionMap.put("allProj", allProj);
		}
		return "success";
	}
	
	public String getProjname() {
		return projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	public String getProjdesc() {
		return projdesc;
	}

	public void setProjdesc(String projdesc) {
		this.projdesc = projdesc;
	}

	public String getProjtags() {
		return projtags;
	}

	public void setProjtags(String projtags) {
		this.projtags = projtags;
	}

	public String getProjtype() {
		return projtype;
	}

	public void setProjtype(String projtype) {
		this.projtype = projtype;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

}
