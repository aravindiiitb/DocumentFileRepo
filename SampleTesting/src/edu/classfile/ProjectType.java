package edu.classfile;


public class ProjectType {
	String projTypeName;
	String projTypeDesc;
	String[] lifeStages;
	
	public String getProjTypeName() {
		return projTypeName;
	}
	public void setProjTypeName(String projTypeName) {
		this.projTypeName = projTypeName;
	}
	public String[] getLifeStages() {
		return lifeStages;
	}
	public void setLifeStages(String[] lifeStages) {
		this.lifeStages = lifeStages;
	}
	public String getProjTypeDesc() {
		return projTypeDesc;
	}
	public void setProjTypeDesc(String projTypeDesc) {
		this.projTypeDesc = projTypeDesc;
	}
	public ProjectType(String projTypeName, String projdesc, String[] lifeStages) {
		super();
		this.projTypeName = projTypeName;
		this.lifeStages = lifeStages;
		this.projTypeDesc = projdesc;
	}
	
}
