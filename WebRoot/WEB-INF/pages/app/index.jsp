<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<a href="addApp.jsp" target="_blank" style="display: inline; height:15px">添加应用</a>
	<form name="form1" method="post" action="">
		<select name="app" id="app" onchange="check(this)">
			<option value="1">派员单位付费</option>
			<option value="2">邀请单位(中方)</option>
			<option value="3">邀请单位(外方)</option>
			<option value="4">按合同付费</option>
			<option value="5">其他付费方式</option>
		</select>
	</form>
</body>
</html>
