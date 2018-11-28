package com.aotain.common.utils.quartz;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 定时任务管理器(单例)
 * 
 * @author liuz@aotian.com
 * @date 2017年6月7日 上午 09:16
 */
public enum QuartzManager {
	instance();

	private SchedulerFactory schedulerFactory;

	private Scheduler scheduler;
	
	private Map<String,IQuartzJob> jobMap;

	/**
	 * 定时任务状态 :0 - 正常运行<br>
	 * 1 - 实例化时发生异常（定时任务管理对象初始化失败）<br>
	 * 2 - scheduler启动失败 <br>
	 * 3 - scheduler已经关闭
	 */
	private int status = 0;

	private QuartzManager() {
		schedulerFactory = new StdSchedulerFactory();
		try {
			Properties properties = new Properties();
		    properties.put("org.quartz.scheduler.instanceName", "STD_SCHEDULER");
		    properties.put("org.quartz.threadPool.threadCount", String.valueOf(30));
		    properties.put("org.quartz.scheduler.skipUpdateCheck", "true");
		    properties.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
		    ((StdSchedulerFactory) schedulerFactory).initialize(properties);
			scheduler = schedulerFactory.getScheduler();
		} catch (SchedulerException e) {
			status = 1;
			e.printStackTrace();
		}
		jobMap = new HashMap<String,IQuartzJob>();
	}
	
	/**
	 * 查询此job是否存在，存在返回对象，否则返回null
	 * @param job
	 * @return
	 */
	public IQuartzJob getJob(IQuartzJob job){
		return jobMap.get(job.getJobGroup()+job.getJobName());
	}

	/**
	 * 启动Quartz定时调度服务
	 */
	public void start() {
		try {
			scheduler.start();
		} catch (SchedulerException e) {
			status = 2;
			throw new RuntimeException(e);
		}
	}

	/**
	 * 关闭Quartz定时调度服务
	 */
	public void shutdown() {
		checkStatus();
		try {
			if (!scheduler.isShutdown()) {
				scheduler.shutdown();
			}
			scheduler = null;
			schedulerFactory = null;
			status = 3;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 任务状态检查，非正常状态抛出异常
	 */
	private void checkStatus() {
		if (status == 0) {
			return;
		}

		String msg = "操作不合法,Quartz定时调度服务初始化失败";
		if (status == 2) {
			msg = "操作不合法,Quartz定时调度服务启动失败";
		} else if (status == 3) {
			msg = "操作不合法,Quartz定时调度服务已关闭";
		}

		throw new RuntimeException(msg);
	}

	/**
	 * 创建一个定时任务
	 * 
	 * @param job
	 */
	public void addJob(IQuartzJob job) {
		checkStatus();

		JobDetail jobDetail = new JobDetail(job.getJobName(), job.getJobGroup(), job.getClass());
		CronTrigger trigger = new CronTrigger(job.getTriggerName(), job.getTriggerGroup());
		try {
			trigger.setCronExpression(job.getCronExpression());// 触发器时间设定

			// 设置Job的完整信息，在执行任务时可以调用到所有参数
			// 必须在调用scheduleJob之前put数据，否则context中将无法取不到
			jobDetail.getJobDataMap().put("job_instance", job);

			scheduler.scheduleJob(jobDetail, trigger);
			jobMap.put(job.getJobGroup()+job.getJobName(),job); // 写缓存
			
			if (!scheduler.isStarted()) {
				scheduler.start();
			}
		} catch (Exception e) {
			throw new RuntimeException("IQuartzJob 添加失败", e);
		}
	}

	/**
	 * 修改Job的执行时间
	 * 
	 * @param job
	 */
	public void modifyJobTime(IQuartzJob job) {
		checkStatus();

		CronTrigger trigger;
		try {
			trigger = (CronTrigger) scheduler.getTrigger(job.getTriggerName(), job.getTriggerGroup());
			if (trigger == null) {
				return;
			}
			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(job.getCronExpression())) {
				deleteJob(job);
				addJob(job);
			}
		} catch (SchedulerException e) {
			throw new RuntimeException("IQuartzJob 定时任务时间修改失败", e);
		}
	}

	/**
	 * 删除一个Job
	 * 
	 * @param job
	 */
	public void deleteJob(IQuartzJob job) {
		checkStatus();

		try {
			JobDetail jobDetail = scheduler.getJobDetail(job.getJobName(), job.getJobGroup());
			if (jobDetail != null) {
				scheduler.pauseTrigger(job.getTriggerName(), job.getTriggerGroup());// 停止触发器
				scheduler.unscheduleJob(job.getTriggerName(), job.getTriggerGroup());// 移除触发器
				scheduler.deleteJob(job.getJobName(), job.getJobGroup());// 删除任务
				jobMap.remove(job.getJobGroup()+job.getJobName());  // 删缓存
				// 清除参数
				jobDetail.getJobDataMap().put("job_instance", job);
			}
		} catch (SchedulerException e) {
			throw new RuntimeException("IQuartzJob 定时任务删除失败", e);
		}
	}

	/**
	 * 用一个新的Job替换原来的Job
	 * 
	 * @param oldJob
	 * @param newJob
	 */
	public void replaceJob(IQuartzJob oldJob, IQuartzJob newJob) {
		checkStatus();

		deleteJob(oldJob);
		addJob(newJob);
	}
}
