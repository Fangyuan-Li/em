<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>应用列表</title>

</head>

<body>
	应用列表
	<br>
	<a href="appCreatePre">新增应用</a>
	<table border="2">
		<tr>
			<td>序号</td>
			<td>应用名称</td>
			<td>应用ID</td>
			<td>应用密钥</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${appList}" var="obj" varStatus="status">
		<tr>
			<td>${status.index+1}</td>
			<td>${obj.appName}</td>
			<td>${obj.appId}</td>
			<td>${obj.secret}</td>
			<td>
				<a href="findEquipments?appId=${obj.appId}">查看设备</a>&nbsp;&nbsp;
				<a href="updateAppPre?appId=${obj.appId}">修改密钥</a>
				<%-- <a href="start?appId=${obj.appId}&secret=${obj.secret}">启用</a> --%>
				<a href="#">启用</a>
				<a href="profileCreatePre?appId=${obj.appName}">自定义设备类型</a>
				<a href="deleteApp?appId=${obj.appId}">删除应用</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>
