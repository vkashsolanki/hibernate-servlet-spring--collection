<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
</head>
<body bgcolor="grey">
<jsp:useBean id="student_bean" class="com.student.bean.Student"></jsp:useBean>
<jsp:useBean id="student_dao" class="com.student.dao.StudentDao"></jsp:useBean>
<jsp:setProperty property="*" name="student_bean"/>
<!-- star * for all properties name set in star (*) and as a refrence variable of bean class in name tag into jsp:setProperty -->
<% 
String message = student_dao.getRegister(student_bean);
if(message.equalsIgnoreCase("success"))
{
	out.println("Record Inserted");
}else
{
	out.println("Not Inserted");
}

%>

</body>
</html>