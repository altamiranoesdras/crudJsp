<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="models.User"%>
<%@ page import="dao.UserDao"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todos los Registros</title>
</head>
<body>
<%
	UserDao dao = new UserDao();
	List<User> userList = dao.getAllUsers();
%>
<table border="1">
	<tr>
		<th>Id</th>
		<th>Nombres</th>
		<th>Apellidos</th>
		<th>Aciones</th>
	</tr>
	<%
	for (User user : userList) {
		%>
		<tr>
		<td><%=user.getId()%></td>
		<td><%=user.getNombres()%></td>
		<td><%=user.getApellidos()%></td>
		<td>
			<a href="UserController?action=editform&userId=<%=user.getId()%>">Actualizar</a>
			<a href="UserController?action=delete&userId=<%=user.getId()%>">Eliminar</a>
		</td>
		</tr>
		<%
	}
	%>
</table>
<p><a href="UserController?action=insert">Agregar nuevo</a></p>
</body>
</html>