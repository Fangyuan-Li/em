package com.em.bean;

public class CommandHis {
	private String commandId;// 命令Id
	private String deviceId;// 设备ID
	private String sleepsend;// 休眠时设备发送的时间间隔
	private String movesend;// 运动时设备发送的时间间隔
	private String waketime;// 运动唤醒时间 单位为秒 建议设置为3 即持续运动三秒设置设备为运动状态
	private String sleeptime;// 设备保持多长时间静止判断其进行休眠状态
	private String senticity;// 加速度传感器灵敏度 一般设置为80-100 正常运动都能检测到
	private String volt;// 电池保护电压阈值*100 一般设置为330 即保护电压为3.3

	public CommandHis() {
		super();
	}

	public CommandHis(String commandId, String deviceId, String sleepsend, String movesend, String waketime,
			String sleeptime, String senticity, String volt) {
		super();
		this.commandId = commandId;
		this.deviceId = deviceId;
		this.sleepsend = sleepsend;
		this.movesend = movesend;
		this.waketime = waketime;
		this.sleeptime = sleeptime;
		this.senticity = senticity;
		this.volt = volt;
	}

	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getSleepsend() {
		return sleepsend;
	}

	public void setSleepsend(String sleepsend) {
		this.sleepsend = sleepsend;
	}

	public String getMovesend() {
		return movesend;
	}

	public void setMovesend(String movesend) {
		this.movesend = movesend;
	}

	public String getWaketime() {
		return waketime;
	}

	public void setWaketime(String waketime) {
		this.waketime = waketime;
	}

	public String getSleeptime() {
		return sleeptime;
	}

	public void setSleeptime(String sleeptime) {
		this.sleeptime = sleeptime;
	}

	public String getSenticity() {
		return senticity;
	}

	public void setSenticity(String senticity) {
		this.senticity = senticity;
	}

	public String getVolt() {
		return volt;
	}

	public void setVolt(String volt) {
		this.volt = volt;
	}

	@Override
	public String toString() {
		return "CommandHis [commandId=" + commandId + ", deviceId=" + deviceId + ", sleepsend=" + sleepsend
				+ ", movesend=" + movesend + ", waketime=" + waketime + ", sleeptime=" + sleeptime + ", senticity="
				+ senticity + ", volt=" + volt + "]";
	}

}
