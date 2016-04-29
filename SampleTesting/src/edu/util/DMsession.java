package edu.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.dispatcher.SessionMap;  

public class DMsession implements SessionAware {
	
	public SessionMap<String,Object> sessionMap;  

	@SuppressWarnings("unchecked")
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sessionMap=(SessionMap)map;  
	}
	
	public void clearSession(){
		 sessionMap.invalidate();  
	}


}
