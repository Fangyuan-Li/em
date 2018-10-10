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

<title>设备类型——命令列表</title>

</head>

<body>
	设备类型——命令列表
	<br>
	<a href="createCommand">新增命令</a>
	设备类型：${type }
	<table border="2">
		<tr>
			<td>序号</td>
			<td>命令字段</td>
			<td>命令说明</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${profileList}" var="obj" varStatus="status">
		<tr>
			<td>${status.index+1}</td>
			<td>${obj.type}</td>
			<td>${obj.producerId}</td>
			<td>
				<a href="findServiceId?appId=${obj.appId}">删除</a>&nbsp;&nbsp;
				<a href="findMethod?appId=${obj.appId}">修改</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>
