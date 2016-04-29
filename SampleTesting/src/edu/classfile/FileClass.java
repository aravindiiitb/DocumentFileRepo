package edu.classfile;

import java.io.File;

public class FileClass {
	
	public FileClass() { }
	
	String fileName;
	File inpfile;
	String fileDescription;
	String presentStage;
	String createddate;
	Integer versionNumber;
	ProjectClass projectClass;
	User user;

	public FileClass(String fileName, File inpfile,
			String fileDescription, String presentStage,
			String createddate, Integer versionNumber, ProjectClass projectClass, User user) {
		super();
		this.fileName = fileName;
		this.inpfile = inpfile;
		this.fileDescription = fileDescription;
		this.presentStage = presentStage;
		this.createddate = createddate;
		this.versionNumber = versionNumber;
		this.projectClass = projectClass;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ProjectClass getProjectClass() {
		return projectClass;
	}

	public void setProjectClass(ProjectClass projectClass) {
		this.projectClass = projectClass;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public File getInpfile() {
		return inpfile;
	}
	public void setInpfile(File inpfile) {
		this.inpfile = inpfile;
	}
	public String getFileDescription() {
		return fileDescription;
	}
	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}
	public String getPresentStage() {
		return presentStage;
	}
	public void setPresentStage(String presentStage) {
		this.presentStage = presentStage;
	}
	
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public Integer getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(Integer versionNumber) {
		this.versionNumber = versionNumber;
	}
}
