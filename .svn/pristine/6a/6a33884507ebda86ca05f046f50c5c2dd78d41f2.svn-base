package com.aotain.common.utils.quartz;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.aotain.common.utils.tools.ReflectUtils;

/**
 * Quartz定时任务加载器
 * 
 * @author liuz@aotian.com
 * @date 2018年8月23日 下午3:56:51
 */
public class QuartzTaskLoadUtils {
	private static Logger logger = Logger.getLogger(QuartzTaskLoadUtils.class);

	/**
	 * 从配置文件加载或者更新定时任务
	 * 
	 * @param properties
	 */
	public static void loadOrRefresh(Properties properties) {
		if (properties == null) {
			logger.warn("load quartz job fail : config file is null");
			return;
		}
		String jobKeyStr = properties.getProperty("quartz.jobs");
		if (StringUtils.isBlank(jobKeyStr)) {
			logger.warn("load quartz job fail : quartz.jobkeys is null");
			return;
		}
		jobKeyStr = jobKeyStr.trim();
		if (jobKeyStr.length() == 0 || (jobKeyStr.length() == 1 && jobKeyStr.equals(","))) {
			logger.warn("load quartz job fail : quartz.jobkeys is null");
			return;
		}
		String[] jobKeys = jobKeyStr.split(",");
		for (String jobKey : jobKeys) {
			String clsName = properties.getProperty("quartz.jobs."+jobKey+".class", null);
			String cronExepression = properties.getProperty("quartz.jobs."+jobKey+".cron", null);
			if (StringUtils.isBlank(clsName)) {
				logger.warn("load quartz job fail : job classs is null , jobkey=" + jobKey);
				continue;
			}
			if(StringUtils.isBlank(cronExepression)){
				logger.warn("load quartz job fail : job cronExepression is null , jobkey=" + jobKey);
				continue;
			}
			try {
				IQuartzJob job = ReflectUtils.createInstance(clsName);
				job.init(jobKey,cronExepression);
				IQuartzJob jobOld = QuartzManager.instance.getJob(job);
				if (jobOld == null) { // 不存在则新增
					logger.info("add quartz job : jobKey="+jobKey+","+job);
					QuartzManager.instance.addJob(job);
				} else if (jobOld.hasModify(job)) { // 存在且已经发生改变时，用新的job替换
					logger.info("refresh quartz job : jobKey="+jobKey+",jobOld="+jobOld+",job="+job);
					QuartzManager.instance.replaceJob(jobOld, job);
				}
			} catch (Exception e) {
				logger.warn("load quartz job fail : job classs is invalidate , jobkey=" + jobKey + ",class=" + clsName,
						e);
			}
		}
	}
}
