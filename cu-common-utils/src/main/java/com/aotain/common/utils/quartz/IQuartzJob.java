package com.aotain.common.utils.quartz;

import org.quartz.Job;

/**
 * 定时任务接口
 * 
 * @author liuz@aotian.com
 * @date 2017年6月7日 上午9:30:00
 */
public interface IQuartzJob extends Job {
	
	public void init(Object... args);
	
	/**
	 * 任务组名
	 * 
	 * @return
	 */
	public String getJobGroup();

	/**
	 * 任务名
	 * 
	 * @return
	 */
	public String getJobName();

	/**
	 * 触发器组
	 * 
	 * @return
	 */
	public String getTriggerGroup();

	/**
	 * 触发器名
	 * 
	 * @return
	 */
	public String getTriggerName();

	/**
	 * 定时任务表达式
	 * 
	 * @return
	 */
	public String getCronExpression();
	
	/**
	 * 是否为已经发生变化
	 * @return
	 */
	public boolean hasModify(IQuartzJob job);
}
