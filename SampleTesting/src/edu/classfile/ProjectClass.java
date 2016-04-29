package edu.classfile;


public class ProjectClass {
	
	String name;
	User user;
	ProjectType projectType;
	String visibility;
	String projDesciption;
	String createdDate;
	String projTags;
	
	public ProjectClass(String name, User user, ProjectType projectType,
			String visibility, String projDesciption, String createdDate,
			String projTags) {
		super();
		this.name = name;
		this.user = user;
		this.projectType = projectType;
		this.visibility = visibility;
		this.projDesciption = projDesciption;
		this.createdDate = createdDate;
		this.projTags = projTags;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ProjectType getProjectType() {
		return projectType;
	}
	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getProjDesciption() {
		return projDesciption;
	}
	public void setProjDesciption(String projDesciption) {
		this.projDesciption = projDesciption;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getProjTags() {
		return projTags;
	}
	public void setProjTags(String projTags) {
		this.projTags = projTags;
	}
}
