<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>取消设备命令</title>

<script type="text/javascript">
	
</script>
</head>

<body>
	<form method="post" id="updateCommand" name="updateCommand" action="updateCommand">
		<a href="index">首页</a><br>
		<input type="hidden" name="deviceId" id="deviceId" value="${deviceId}"/>
		取消设备命令<br>
		请输入命令ID：<input type="text" name="deviceCommandId" id="deviceCommandId"/>
		<input type="submit" value="提交">
	</form>
</body>
</html>
