<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="">
<table border=3>
<tr>
   <th>id</th>
   <th>name</th>
   <th>company</th>
   <th>salary</th>
 </tr>
     <core:forEach var="empobject" items="${emplist}">
     
     <tr>
         <td> ${empobject.id}</td>
          <td> ${empobject.name}</td>
           <td> ${empobject.company}</td>
             <td>${empobject.salary}</td>
      </tr>
          
     
     
     
     
     
     </core:forEach>

</table>
</form>
</body>
</html>