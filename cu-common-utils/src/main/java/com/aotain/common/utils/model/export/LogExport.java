package com.aotain.common.utils.model.export;

import com.aotain.common.utils.model.msg.BaseVo;

/**
 * 访问日志导出、监测过滤日志导出、URL去重统计导出、活跃资源IP信息导出、活跃资源域名信息导出、基础数据异常监测数据导出 实体类
 * 
 * @author Administrator
 * 
 */
/**
 * @author kuangbin
 *
 */
public class LogExport extends BaseVo {

	private static final long serialVersionUID = -5870675559719037569L;
	private Long transid;
	private String houseidstr;
	private String sql;
	private Long createtime;
	private Integer logType; // 1:访问日志 2：监测过滤日志 3:URL去重统计 4：活跃IP 5：活跃域名 6：基础数据异常监测 7:违法违规网站
	private Integer fileNum;
	
	public Long getTransid() {
		return transid;
	}

	public void setTransid(Long transid) {
		this.transid = transid;
	}

	public String getHouseidstr() {
		return houseidstr;
	}

	public void setHouseidstr(String houseidstr) {
		this.houseidstr = houseidstr;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Long getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}

	public Integer getLogType() {
		return logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	public Integer getFileNum() {
		return fileNum;
	}

	public void setFileNum(Integer fileNum) {
		this.fileNum = fileNum;
	}

}
