<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>设备发送指令</title>

<script type="text/javascript">
	
</script>
</head>

<body>
	<form method="post" id="postDeviceCommand" name="postDeviceCommand" action="postDeviceCommand">
		<a href="index">首页</a><br>
		发送指令<br>
		<input type="text" name="deviceId" id="deviceId" value="${deviceId }">
		<table border="1">
			<tr>
				<td>SleepTimeSendS</td>
				<td><input type="text" name="SleepTimeSendS" id="SleepTimeSendS"/></td>
				<td><font size="2" color="red">休眠时设备发送的时间间隔</font></td>
			</tr>
			<tr>
				<td>Senticity</td>
				<td><input type="text" name="Senticity" id="Senticity"/></td>
				<td><font size="2" color="red">加速度传感器灵敏度 一般设置为80-100 正常运动都能检测到</font></td>
			</tr>
			<tr>
				<td>MoveSendTimeS</td>
				<td><input type="text" name="MoveSendTimeS" id="MoveSendTimeS"/></td>
				<td><font size="2" color="red">运动时设备发送的时间间隔</font></td>
			</tr>
			<tr>
				<td>SleepTime</td>
				<td><input type="text" name="SleepTime" id="SleepTime"/></td>
				<td><font size="2" color="red">设备保持多长时间静止判断其进行休眠状态</font></td>
			</tr>
			<tr>
				<td>VoltThreshod</td>
				<td><input type="text" name="VoltThreshod" id="VoltThreshod"/></td>
				<td><font size="2" color="red">电池保护电压阈值*100  一般设置为330    即保护电压为3.3</font></td>
			</tr>
			<tr>
				<td>wakeTime</td>
				<td><input type="text" name="wakeTime" id="wakeTime"/></td>
				<td><font size="2" color="red">运动唤醒时间 单位为秒 建议设置为3 即持续运动三秒设置设备为运动状态</font></td>
			</tr>
		</table>
		<input type="submit" value="发送">
	</form>
</body>
</html>
