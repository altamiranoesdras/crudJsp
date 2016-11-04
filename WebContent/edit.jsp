<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="models.User"%>
<%@ page import="dao.UserDao"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<%
	User user = new User();
	UserDao dao = new UserDao();
%>
<form method="POST" action='UserController' name="frmEditUser"><input
	type="hidden" name="action" value="edit" /> <%
 	String uid = request.getParameter("userId");
 	if (!((uid) == null)) {
 		int id = Integer.parseInt(uid);
 		user = dao.getUserById(id);
		%>
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="userId" readonly="readonly"
					value="<%=user.getId()%>"></td>
			</tr>
			<tr>
				<td>Nombres</td>
				<td><input type="text" name="firstName" value="<%=user.getNombres()%>"/></td>
			</tr>
			<tr>
				<td>Apellidos</td>
				<td><input type="text" name="lastName" value="<%=user.getApellidos()%>"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Actualizar" /></td>
			</tr>
		</table>
		<%
	} else
		out.println("Registro no encontrado");
%>
</form>
</body>
</html>