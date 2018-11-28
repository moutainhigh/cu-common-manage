package com.aotain.common.utils.model.report;

/**
 * 999返回文件Redis缓存对象记录
 * 
 * @author liuz@aotian.com
 * @date 2018年8月23日 下午1:46:46
 */
public class SmmsResultCache {
	private long taskId;
	private String fileName;
	private int status;
	private int fileType;
	private long reciveTime = System.currentTimeMillis() / 1000; // 接收时间 s
	private long lastDealTime = 0; // 上次处理时间 s
	private int dealTimes = 0; // 处理次数

	public long getReciveTime() {
		return reciveTime;
	}

	public void setReciveTime(long reciveTime) {
		this.reciveTime = reciveTime;
	}

	public long getLastDealTime() {
		return lastDealTime;
	}

	public void setLastDealTime(long lastDealTime) {
		this.lastDealTime = lastDealTime;
	}

	public int getDealTimes() {
		return dealTimes;
	}

	public void setDealTimes(int dealTimes) {
		this.dealTimes = dealTimes;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "SmmsResultCache [taskId=" + taskId + ", fileName=" + fileName + ", status=" + status + ", fileType="
				+ fileType + ", reciveTime=" + reciveTime + ", lastDealTime=" + lastDealTime + ", dealTimes="
				+ dealTimes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SmmsResultCache other = (SmmsResultCache) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		return true;
	}
	
}
