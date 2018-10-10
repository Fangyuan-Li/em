<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改应用密钥</title>

<script type="text/javascript">
	
</script>
</head>

<body>
	<form method="post" id="updateApp" name="updateApp" action="updateApp">
		<a href="index">首页</a><br>
		修改应用密钥<br>
		应用Id:${appName }<br>
		<input type="hidden" name="appId" value="${appId }">
		<table border="1">
			<tr>
				<td>应用密钥</td>
				<td><input type="text" name="secret" id="secret"/></td>
			</tr>
		</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>
