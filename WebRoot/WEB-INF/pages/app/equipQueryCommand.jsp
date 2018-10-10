<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>查询发送的指令</title>

<script type="text/javascript">
	
</script>
</head>

<body>
	<form method="post" id="postDeviceCommand" name="postDeviceCommand" action="postDeviceCommand">
		<a href="index">首页</a><br>
		发送的指令<br>
		<div style="padding-left:30px; ">${qdcod }</div>
	</form>
</body>
</html>
