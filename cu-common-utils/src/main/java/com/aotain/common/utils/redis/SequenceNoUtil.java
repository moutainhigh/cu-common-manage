package com.aotain.common.utils.redis;

import com.aotain.common.config.ContextUtil;
import com.aotain.common.config.redis.BaseRedisService;

public class SequenceNoUtil {

    /**
     * redis实例
     */
    @SuppressWarnings("unchecked")
    private static BaseRedisService<String, String, Long> rediscluster = ContextUtil.getContext().getBean("baseRedisServiceImpl",BaseRedisService.class);
    
    /**
     * SequenceNo在redis里面的key
     */
    private static String REDIS_SEQUENCENO_KEY = "global_policy_sequenceno";
    

    /**
     * 单例
     */
    private static SequenceNoUtil instance = null;
    
    /**
     * 获得单例
     */
    public synchronized static SequenceNoUtil getInstance(){
        if(instance == null){
            instance = new SequenceNoUtil();
        }
        
        return instance;
    }
    
    /**
     * 获得SequenceNo
     * @param config
     * @param messageType
     * @return
     */
    public Long getSequenceNo(int messageType){
        
        return rediscluster.hincrByHash(REDIS_SEQUENCENO_KEY, String.valueOf(messageType), 1L);
    }
}
