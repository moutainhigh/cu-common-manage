package com.aotain.common.utils.redis;

import com.aotain.common.config.ContextUtil;
import com.aotain.common.config.redis.BaseRedisService;

public class ApproveIdUtil {
    
    /**
     * redis实例
     */
    @SuppressWarnings("unchecked")
    private static BaseRedisService<String, String, Long> rediscluster = ContextUtil.getContext().getBean("baseRedisServiceImpl",BaseRedisService.class);

    private static String REDIS_APPROVEID_KEY = "global_approve_id";
    
    /**
     * 单例
     */
    private static ApproveIdUtil instance = null;
    
    /**
     * 获得单例
     */
    public synchronized static ApproveIdUtil getInstance(){
        if(instance == null){
            instance = new ApproveIdUtil();
        }
        
        return instance;
    }
    
    public Long getApproveId(){
    	return rediscluster.incr(REDIS_APPROVEID_KEY);
    }
}
