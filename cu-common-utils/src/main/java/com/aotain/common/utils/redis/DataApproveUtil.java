package com.aotain.common.utils.redis;


import org.apache.commons.lang3.StringUtils;

import com.aotain.common.config.ContextUtil;
import com.aotain.common.config.redis.BaseRedisService;

public class DataApproveUtil {
    
    /**
     * redis实例
     */
    @SuppressWarnings("unchecked")
    private static BaseRedisService<String, String, String> rediscluster = ContextUtil.getContext().getBean("baseRedisServiceImpl",BaseRedisService.class);

    private static String DATA_APPROVE_CACHE = "data_approve_cache";
    
    /**
     * 单例
     */
    private static DataApproveUtil instance = null;
    
    /**
     * 获得单例
     */
    public synchronized static DataApproveUtil getInstance(){
        if(instance == null){
            instance = new DataApproveUtil();
        }
        
        return instance;
    }
    
    public void setDataApprove(String field,Long approveId) {
		rediscluster.putHash(DATA_APPROVE_CACHE,field,approveId.toString());
	}

	public Long getDataApprove(String field) {
		String value=rediscluster.getHash(DATA_APPROVE_CACHE, field);
		if(StringUtils.isBlank(value)){
			return null;
		}
		return Long.valueOf(value);
	}
	
}
