package com.aotain.common.utils.quartz;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 测试定时任务
 *
 * @author liuz@aotian.com
 * @date 2018年8月23日 下午3:36:08
 */
public abstract class AbsQuartzJob implements IQuartzJob {
    private static String JOB_GROUP = "COMMON_JOB_GROUP";
    private static String JOB_NAME_PRE = "_JOB_";
    private static String TRIGGER_GROUP = "COMMON_TRIGGER_GROUP";
    private static String TRIGGER_NAME_PRE = "_TRIGGER_";
    private String cronExpression;
    private String jobKey;
    private String jobId = String.valueOf(System.currentTimeMillis()); // 默认为时间戳

    @Override
    public void init(Object... args) {
        if (args == null || args.length < 2) {
            throw new RuntimeException("illegal arguments , init(jobKey,cronExpression)");
        }
        String jobKey = args[0].toString();
        String cronExpression = args[1].toString();
        this.jobKey = jobKey;
        this.cronExpression = cronExpression;
        if ("".equals(jobKey.trim())) {
            this.jobKey = "DEFAULT";
        }
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        IQuartzJob jobInstance = (IQuartzJob) jobDetail.getJobDataMap().get("job_instance");
        run(jobInstance);
    }

    /**
     * 任务定时执行方法
     *
     * @param job 定时任务配置信息
     */
    public abstract void run(IQuartzJob job);

    @Override
    public String getJobGroup() {
        return JOB_GROUP;
    }

    @Override
    public String getJobName() {
        return jobKey + JOB_NAME_PRE;
    }

    @Override
    public String getTriggerGroup() {
        return TRIGGER_GROUP;
    }

    @Override
    public String getTriggerName() {
        return jobKey + TRIGGER_NAME_PRE;
    }

    @Override
    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @Override
    public boolean hasModify(IQuartzJob job) {
        String curKey = this.getClass().getName() + getJobGroup() + getJobName() + getCronExpression();
        String jobKey = job.getClass().getName() + job.getJobGroup() + job.getJobName() + job.getCronExpression();
        return !curKey.equals(jobKey);
    }

    @Override
    public String toString() {
        return getJobGroup() + "-" + getJobName() + "-" + getCronExpression();
    }

    public String getJobKey() {
        return jobKey;
    }

    public String getJobId() {
        return jobId;
    }
}
