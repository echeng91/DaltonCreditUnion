<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Landing</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<form action="AccountDetail" method="post">
					<p>View existing account</p>
					<br> <input type="submit" value="View Existing Account">

				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="CreateNewAccount" method="post">
					<p>Create a New Account</p>
					<select name="accounttype">
						<option value="checking">Checking</option>
						<option value="saving">Saving</option>

					</select> <br> <input type="submit" value="Create New Account">

				</form>
			</td>
		</tr>
	</table>
	<p> kindly note Your New Account ID is :${message}</p>

</body>
</html>