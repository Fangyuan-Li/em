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

<title>设备类型——属性列表</title>

</head>

<body>
	设备类型——属性列表
	<br>
	<a href="createProperty">新增属性</a>
	设备类型：${type }
	<table border="2">
		<tr>
			<td>序号</td>
			<td>属性字段</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${profileList}" var="obj" varStatus="status">
		<tr>
			<td>${status.index+1}</td>
			<td>${obj.field}</td>
			<td>
				<a href="updateProperty?appId=${obj.field}">修改</a>&nbsp;&nbsp;
				<a href="deleteProperty?appId=${obj.field}">删除</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>
