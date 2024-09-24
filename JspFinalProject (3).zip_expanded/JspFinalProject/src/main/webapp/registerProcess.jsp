<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <jsp:useBean id="userObj" class="com.androjava.dto.Users"></jsp:useBean>
 <jsp:useBean id="userdao" class="com.androjava.dao.UserDaoImpl"></jsp:useBean>
 <jsp:setProperty property="*" name="userObj"/>
 
 <% 
 String msg=userdao.registerUser(userObj);
   if(msg.equalsIgnoreCase("sucess"))
  {
	response.sendRedirect("index.jsp");  
	  
  }
 %>
 
 




</body>
</html>