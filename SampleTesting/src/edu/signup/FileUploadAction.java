package edu.signup;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import edu.classfile.FileClass;
import edu.classfile.ProjectClass;
import edu.classfile.User;
import edu.dao.CreateProjectObject;
import edu.dao.FileUploadDAO;
import edu.util.DMsession;

public class FileUploadAction extends DMsession { 

	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String destPath;

	private String fileDesc;
	private String presentStage;
	private String clickedOn;
	
	private InputStream fileInputStream;
	private String downloadFile;

	public String uploadFile(){		
		User user = (User) sessionMap.get("user");
		String index = (String) sessionMap.get("clickedIndex");
		
		ProjectClass[] p = (ProjectClass[]) sessionMap.get("allProj");
		
		ProjectClass temp = p[Integer.parseInt(index)];
		/*Getting all the files which has this projectClass*/
		FileClass[] files = (FileClass[]) sessionMap.get("allFiles");
		Integer revision = 0;
		if(files != null){
			revision = files.length;
		}
		else {
			revision = 0;
		}
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
		System.out.println(myFileFileName);
		System.out.println(presentStage);
		System.out.println(fileDesc);
		System.out.println("revision: "+revision);
		
		FileClass file = new FileClass(myFileFileName,myFile,fileDesc,presentStage,df.format(dateobj),revision,temp,user);

		destPath = "E:/6th Sem/Data Modelling/DocumentRepo/"+user.getEmail();
		System.out.println(destPath + "/" + myFileFileName);
		try{
			System.out.println("Src File name: " + myFile);
			System.out.println("Dst File name: " + myFileFileName);

			File destFile  = new File(destPath, myFileFileName);
			FileUtils.copyFile(myFile, destFile);

			FileUploadDAO fileUploadDAO = new FileUploadDAO();
			fileUploadDAO.fileUpload(file);
			
			/*Getting all the files which has this projectClass*/
			FileUploadDAO fileDAOobj = new FileUploadDAO();
			FileClass[] fls = fileDAOobj.getAllFiles(user,temp);
			
			sessionMap.put("allFiles",fls);
				
			
		}catch(IOException e){
			e.printStackTrace();
			return "failure";
		}
		return "success";
	}
	public String getFileDesc() {
		return fileDesc;
	}
	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}
	public String getPresentStage() {
		return presentStage;
	}
	public void setPresentStage(String presentStage) {
		this.presentStage = presentStage;
	}
	public String execute() throws Exception {
		//clickedOn = "0";
		//System.out.println("clickedon: "+clickedOn);
		User usr = (User) sessionMap.get("user");
		//FileClass[] f = (FileClass[]) sessionMap.get("allFiles");
		//String filename = f[Integer.parseInt(clickedOn)].getFileName();
		String filename = (String) sessionMap.get("downloadFile");
		String destPath = "E:/6th Sem/Data Modelling/DocumentRepo/"+usr.getEmail();

		System.out.println("atatchement;filename=" + "'" +filename + "'");
		System.out.println(destPath + "/" + filename);
		fileInputStream = new FileInputStream(new File(destPath + "/" + filename));
		downloadFile = "atatchement;filename=" + "'" +filename + "'"; 
		return "success";
	}
	/*public String getFileDetails() throws FileNotFoundException {

		User usr = (User) sessionMap.get("user");
		String destPath = "E:/6th Sem/Data Modelling/DocumentRepo/"+usr.getEmail();

		FileClass[] f = (FileClass[]) sessionMap.get("myFiles");
		FileClass req = f[clickedIndex];
		System.out.println("atatchement;filename=" + "'" +filename + "'");
		System.out.println(destPath + "/" + filename);
		fileInputStream = new FileInputStream(new File(destPath + "/" + filename));
		downloadFile = "atatchement;filename=" + "'" +filename + "'"; 
		return "success";
	}*/

	/*public String removefile() {
		System.out.println("index clicked: " + this.removeIndex);
		return "success";
	}*/

	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
	public String getDownloadFile() {
		return downloadFile;
	}
	public void setDownloadFile(String downloadFile) {
		this.downloadFile = downloadFile;
	}
	public String getClickedOn() {
		return clickedOn;
	}
	public void setClickedOn(String clickedOn) {
		this.clickedOn = clickedOn;
	}
}
