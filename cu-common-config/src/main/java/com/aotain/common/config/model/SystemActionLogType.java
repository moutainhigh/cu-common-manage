package com.aotain.common.config.model;

import java.util.ArrayList;
import java.util.List;


/**
 * 系统操作日志类型
 */
public enum SystemActionLogType {	
	CREATE("增加"),
	DELETE("删除"),
	UPDATE("修改"),
	READ("查询"),
	REPORT("上报"),
	RESEND("重发"),
	DEAL("处置"),
	RECOVER("恢复"),
	IMPORT("导入"),
	EXPORT("导出"),
	APPROVE("预审"),
	LOGIN("登录"),
	LOGINOUT("退出"),
	CASCADEAPPROVE("级联预审"),
	REVOKEAPPROVE("撤销预审"),
	DETAIINFO("详情查看"),
	CHANGE_NATURE("属性变更"),
	DOWNLOAD_TEMPLATE("模板下载"),
	DOWNLOAD_ERROR_FILE("错误文件下载"),
	DOWNLOAD_CHECK_RESULT("核验结果下载");
	
	private String description;

	public String getDescription() {
		return description;
	}

	private SystemActionLogType(String description) {
		this.description = description;
	}
	
	public static List<LabelValueBean> getSystemActionLogTypes(){
		List<LabelValueBean> lvbs = new ArrayList<LabelValueBean>();
		for(SystemActionLogType item : SystemActionLogType.values()){
			LabelValueBean lvb = new LabelValueBean();
			lvb.setItemLabel(item.getDescription());
			lvb.setItemValue(item.ordinal() + "");
			lvbs.add(lvb);
		}
		return lvbs;
	}
	
	/**
	 * 根据ordinal值获取枚举对象
	 * @param ordinal
	 * @return SystemActionLogType
	 */
	public static SystemActionLogType valueOf(int ordinal) {
		SystemActionLogType[] systemActionLogTypes = SystemActionLogType.values();
        if (ordinal < 0 || ordinal >= systemActionLogTypes.length) {
            throw new IndexOutOfBoundsException("Invalid ordinal");
        }
        return systemActionLogTypes[ordinal];
    }
	
}
