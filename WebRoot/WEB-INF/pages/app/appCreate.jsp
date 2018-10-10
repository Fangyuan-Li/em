<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加应用</title>

<script type="text/javascript">
	
</script>
</head>

<body>
	<form method="post" id="appCreate" name="appCreate" action="appCreate">
		<a href="index">首页</a><br>
		添加应用<br>
		<table border="1">
			<tr>
				<td>应用名称</td>
				<td><input type="text" name="appName" id="appName"/></td>
			</tr>
			<tr>
				<td>应用ID</td>
				<td><input type="text" name="appId" id="appId"/></td>
			</tr>
			<tr>
				<td>应用密钥</td>
				<td><input type="text" name="secret" id="secret"/></td>
			</tr>
		</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>
