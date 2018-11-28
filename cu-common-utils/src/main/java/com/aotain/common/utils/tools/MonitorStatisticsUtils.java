package com.aotain.common.utils.tools;

import org.apache.curator.shaded.com.google.common.collect.Maps;
import org.apache.log4j.Logger;

import com.aotain.common.config.ContextUtil;
import com.aotain.common.utils.monitorstatistics.ExceptionCollector;
import com.aotain.common.utils.monitorstatistics.QuartzThreadMonitorInterceptor;
import com.aotain.common.utils.monitorstatistics.TypeConstant;

import java.util.Map;

/**
 * 线程异常监听工具类，对ExceptionCollector进行封装，便于调用
 * 
 * @author liuz@aotian.com
 * @date 2017年12月25日 下午3:43:36
 */
public class MonitorStatisticsUtils {
	private static ExceptionCollector exceptionCollector;
	private static QuartzThreadMonitorInterceptor quartzMonitor;
	private static Logger logger = Logger.getLogger(MonitorStatisticsUtils.class);
	
	private static String STATIS_KEY_FORMAT = "%s_%s_exception";

	private static void getEC() {
		if (exceptionCollector == null) {
			synchronized (MonitorStatisticsUtils.class) {
				try {
					exceptionCollector = ContextUtil.getContext().getBean(ExceptionCollector.class);
				} catch (Exception e) {
					logger.error("empty exceptionCollector!",e);
				}
			}
		}
	}

	public static void initModuleMap(Map<String,String> moduleMap){
		getEC();
		if (exceptionCollector != null) {
			try {
				exceptionCollector.initModuleMap(moduleMap);
			} catch (Exception e1) {
				logger.error("empty exceptionCollector!",e1);
			}
		}
	}
	
	/**
	 * 统计模块初始化(不包含线程统计功能)
	 * @param module
	 */
	public static void initModuleNoThread(String module) {
		Map<String,String> map = Maps.newHashMap();
		String key = String.format(STATIS_KEY_FORMAT, module,TypeConstant.EXCEPTION_TYPE_DB);
		map.put(key, "0");
		key = String.format(STATIS_KEY_FORMAT, module,TypeConstant.EXCEPTION_TYPE_REDIS);
		map.put(key, "0");
		key = String.format(STATIS_KEY_FORMAT, module,TypeConstant.EXCEPTION_TYPE_KAFKA);
		map.put(key, "0");
		key = String.format(STATIS_KEY_FORMAT, module,TypeConstant.EXCEPTION_TYPE_APPLICATION);
		map.put(key, "0");
		key = String.format(STATIS_KEY_FORMAT, module,TypeConstant.EXCEPTION_TYPE_OTHER);
		map.put(key, "0");
		key = String.format(STATIS_KEY_FORMAT, module,TypeConstant.EXCEPTION_TYPE_HIVE);
		map.put(key, "0");
		getEC();
		if (exceptionCollector != null) {
			try {
				exceptionCollector.initModuleMap(map);
			} catch (Exception e1) {
				logger.error("empty exceptionCollector!",e1);
			}
		}
	}
	
	/**
	 * 统计模块初始化(包含线程统计功能)
	 * @param module
	 */
	public static void initModuleALL(String module) {
		Map<String,String> map = Maps.newHashMap();
		String key = String.format(STATIS_KEY_FORMAT, module,TypeConstant.EXCEPTION_TYPE_DB);
		map.put(key, "0");
		key = String.format(STATIS_KEY_FORMAT, module,TypeConstant.EXCEPTION_TYPE_REDIS);
		map.put(key, "0");
		key = String.format(STATIS_KEY_FORMAT, module,TypeConstant.EXCEPTION_TYPE_KAFKA);
		map.put(key, "0");
		key = String.format(STATIS_KEY_FORMAT, module,TypeConstant.EXCEPTION_TYPE_APPLICATION);
		map.put(key, "0");
		key = String.format(STATIS_KEY_FORMAT, module,TypeConstant.EXCEPTION_TYPE_OTHER);
		map.put(key, "0");
		key = String.format(STATIS_KEY_FORMAT, module,TypeConstant.EXCEPTION_TYPE_HIVE);
		map.put(key, "0");
		key = String.format(STATIS_KEY_FORMAT, module,TypeConstant.EXCEPTION_TYPE_THREAD);
		map.put(key, "0");
		getEC();
		if (exceptionCollector != null) {
			try {
				exceptionCollector.initModuleMap(map);
			} catch (Exception e1) {
				logger.error("empty exceptionCollector!",e1);
			}
		}
	}

	private static void getQM() {
		if (quartzMonitor == null) {
			synchronized (MonitorStatisticsUtils.class) {
				try {
					quartzMonitor = ContextUtil.getContext().getBean(QuartzThreadMonitorInterceptor.class);
				} catch (Exception e) {
					logger.error("empty quartzMonitor!",e);
				}
			}
		}
	}

	public static void addEvent(String module, String type, int count) {
		getEC();
		if (exceptionCollector != null) {
			try {
				exceptionCollector.addEvent(module, type, count);
			} catch (Exception e1) {
				logger.error("write event error !",e1);
			}
		}
	}

	public static void addEvent(String module, Exception e) {
		getEC();
		if (exceptionCollector != null) {
			try {
				exceptionCollector.addEvent(module, e);
			} catch (Exception e1) {
				logger.error("write event error !",e1);
			}
		}
	}
	
	/**
	 * 获取Quartz定时任务异常的数量
	 */
	public static int getQuartErrorThreadCount() {
		getQM();
		if (quartzMonitor != null) {
			try {
				return quartzMonitor.countErrorThreads();
			} catch (Exception e1) {
				logger.error("write event error !",e1);
			}
		}
		return -1;
	}
}
