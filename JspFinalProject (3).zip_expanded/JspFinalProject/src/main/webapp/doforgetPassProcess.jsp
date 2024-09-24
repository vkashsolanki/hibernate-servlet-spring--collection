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
 String msg=userdao.forgetPassword(userObj);
 if(msg.equalsIgnoreCase("pass"))
 {
out.println("Your password ResetLink hasbeen sent on your mail Please check your mail to login");
 //out.println("<a href='index.jsp'>Click here to Login</a>");
 
 }
else
{
out.println(msg);	
}

 %>
 
 




</body>
</html>