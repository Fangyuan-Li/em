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

<title>设备列表</title>

</head>

<body>
	<a href="index">首页</a><br>
	${appId }应用的设备列表<br>
	<a href="addEquipPre?appId=${appId }">新增</a>
	<table border="2">
		<tr>
			<td>序号</td>
			<td>设备名称</td>
			<td>设备ID</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${equipList}" var="obj" varStatus="status">
		<tr>
			<td>${status.index+1}</td>
			<td>${obj.deviceName}</td>
			<td>${obj.deviceId}</td>
			<td>
				<a href="postDeviceCommandPre?deviceId=${obj.deviceId}">发送指令</a>&nbsp;&nbsp;
				<a href="queryCommand?deviceId=${obj.deviceId}">查询历史命令</a>&nbsp;&nbsp;
				<a href="updateCommandPre?deviceId=${obj.deviceId}">撤销命令</a>&nbsp;&nbsp;
				<a href="createCmdCancelTask?deviceId=${obj.deviceId}">撤销所有命令</a>&nbsp;&nbsp;
				<a href="queryCmdCancelTask?deviceId=${obj.deviceId}">查询撤销任务</a>
				<a href="deleteEquip?deviceId=${obj.deviceId}&appId=${appId }">删除设备</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>
