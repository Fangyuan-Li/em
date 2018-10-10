<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加设备类型</title>

<script type="text/javascript">
	
</script>
</head>

<body>
	<form method="post" id="profileCreate" name="profileCreate" action="profileCreate">
		<a href="index">首页</a><br>
		添加设备类型<br>
		应用名称：<input type="text" name="appName" id="appName" value="${appName }"/>
		<table border="1">
			<tr>
				<td>设备类型</td>
				<td><input type="text" name="type" id="type"/></td>
			</tr>
			<tr>
				<td>厂商名称</td>
				<td><input type="text" name="producer" id="producer"/></td>
			</tr>
			<tr>
				<td>服务名称</td>
				<td><input type="text" name="serviceId" id="serviceId"/></td>
			</tr>
			<tr>
				<td>方法名称</td>
				<td><input type="text" name="method" id="method"/></td>
			</tr>
		</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>
