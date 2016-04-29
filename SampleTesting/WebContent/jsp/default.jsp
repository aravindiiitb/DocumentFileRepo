<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<form action="signupaction">

<input type="text" name="email"/>
<br>
<input type="password" name="password"/>
<input type="submit" value="submit"/>


</form>

<!-- 
<form action="dropDown">
</form> -->
<select id="ddlViewBy" >

  <option select="selected">Select any option</option>
  <option value="1">test1</option>
  <option value="2" >test2</option>
  <option value="3">test3</option>
  
</select>

<br><br>
<input type="submit" value = "submit" onclick="checkAgree();" />
<script>
function checkAgree(){
	var xmlhttp;
	var e = document.getElementById("ddlViewBy");
	var strUser = e.options[e.selectedIndex].text;
	/* alert(strUser);
	var url="dropDown?pickUp="+strUser;
	  if (window.XMLHttpRequest)
	 {
   		  xmlhttp=new XMLHttpRequest();
	 }
 
     else
     {
         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
     } 
	 xmlhttp.open("POST", url, true);
	 xmlhttp.send();
	 location.href = url; */
	
}

</script>




</body>
</html>