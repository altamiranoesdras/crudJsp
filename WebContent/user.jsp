<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New User</title>
</head>
<body>
<form method="POST" action='UserController' name="frmAddUser"><input
	type="hidden" name="action" value="insert" />
<p><b>Nuevo Registro</b></p>
<table>
	<tr>
		<td>ID</td>
		<td><input type="text" name="userid" /></td>
	</tr>
	<tr>
		<td>Nombres</td>
		<td><input type="text" name="firstName" /></td>
	</tr>
	<tr>
		<td>Apellidos</td>
		<td><input type="text" name="lastName" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Guardar" /></td>
	</tr>
</table>
</form>
<p><a href="UserController?action=listUser">Ver todos los registros</a></p>
</body>
</html>