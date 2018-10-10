<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加设备</title>

<script type="text/javascript">
	
</script>
</head>

<body>
	<form method="post" id="addEquip" name="addEquip" action="addEquip">
		<a href="index">首页</a><br>
		添加设备<br>
		<input type="hidden" name="appId" value="${appId }">
		<table border="1">
			<tr>
				<td>设备名称</td>
				<td><input type="text" name="deviceName" id="deviceName"/></td>
			</tr>
			<tr>
				<td>设备ID</td>
				<td><input type="text" name="deviceId" id="deviceId"/></td>
			</tr>
		</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>
