package com.aotain.common.utils.redis;

import com.aotain.common.config.ContextUtil;
import com.aotain.common.config.redis.BaseRedisService;

public class MessageNoUtil {
    
    /**
     * redis实例
     */
    @SuppressWarnings("unchecked")
    private static BaseRedisService<String, String, Long> rediscluster = ContextUtil.getContext().getBean("baseRedisServiceImpl",BaseRedisService.class);

    /**
     * MessageNo在redis里面的key
     */
    private static String REDIS_MESSAGENO_KEY = "global_policy_messageno";
    
    /**
     * 单例
     */
    private static MessageNoUtil instance = null;
    
    /**
     * 获得单例
     */
    public synchronized static MessageNoUtil getInstance(){
        if(instance == null){
            instance = new MessageNoUtil();
        }
        
        return instance;
    }
    
    /**
     * 获得MessageNo
     * @param config
     * @param messageType
     * @return
     */
    public Long getMessageNo(int messageType){
        
        return rediscluster.hincrByHash(REDIS_MESSAGENO_KEY, String.valueOf(messageType), 1L);
    }
}
