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

<title>设备类型列表</title>

</head>

<body>
	设备类型列表
	<br>
	<a href="appCreatePre">新增设备类型</a>
	<table border="2">
		<tr>
			<td>序号</td>
			<td>设备类型ID</td>
			<td>设备类型</td>
			<td>厂商名称</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${profileList}" var="obj" varStatus="status">
		<tr>
			<td>${status.index+1}</td>
			<td>${obj.id}</td>
			<td>${obj.type}</td>
			<td>${obj.producerId}</td>
			<td>
				<a href="findProperties?appId=${obj.id}">服务属性</a>&nbsp;&nbsp;
				<a href="findMethods?appId=${obj.id}">方法命令</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>
