package com.aotain.common.utils.redis;

import org.apache.commons.lang3.StringUtils;

import com.aotain.common.config.ContextUtil;
import com.aotain.common.config.redis.BaseRedisService;

public class DataSubmitUtil {
    
    /**
     * redis实例
     */
    @SuppressWarnings("unchecked")
    private static BaseRedisService<String, String, String> rediscluster = ContextUtil.getContext().getBean("baseRedisServiceImpl",BaseRedisService.class);

    private static String DATA_SUBMIT_CACHE = "data_submit_cache";
    
    /**
     * 单例
     */
    private static DataSubmitUtil instance = null;
    
    /**
     * 获得单例
     */
    public synchronized static DataSubmitUtil getInstance(){
        if(instance == null){
            instance = new DataSubmitUtil();
        }
        
        return instance;
    }
    
    public void setDataSubmit(String field,Long submitId) {
 		rediscluster.putHash(DATA_SUBMIT_CACHE,field,submitId.toString());
 	}

 	public Long getDataSubmit(String field) {
 		String value=rediscluster.getHash(DATA_SUBMIT_CACHE, field);
		if(StringUtils.isBlank(value)){
			return null;
		}
		return Long.valueOf(value);
 	}
}
