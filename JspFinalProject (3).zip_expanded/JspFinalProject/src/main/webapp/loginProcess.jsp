<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <jsp:useBean id="userObj1" class="com.androjava.dto.Users"></jsp:useBean>
 <jsp:useBean id="userdao1" class="com.androjava.dao.UserDaoImpl"></jsp:useBean>
 <jsp:setProperty property="*" name="userObj1"/>
 
 <% 
 String msg=userdao1.loginUser(userObj1);
 out.println("Invalid User Name or Password");
 if(msg.equals("fail"))
 {
  %>
 <jsp:include page="index.jsp"></jsp:include>
 <%
 }
 else
 {
 %>
<jsp:forward page="welcome.jsp"></jsp:forward>

<%
}
%>

</body>
</html>