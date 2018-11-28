package com.aotain.common.policyapi.utils;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.aotain.common.config.ContextUtil;
import com.aotain.common.config.redis.BaseRedisService;
import com.aotain.common.policyapi.model.HouseBindPolicyCache;

/**
 * 发送机房绑定策略
 * 
 * @author liuz@aotian.com
 * @date 2018年3月24日 下午2:10:42
 */
public class HouseBindCacheUtils {
	private static HouseBindCacheUtils instance;
	public static String HOUSE_BIND_CACHE_KEY = "HouseBindPolicyCache";
	public static String HOUSE_BIND_CACHE_FIELD_FORMATE = "%d_%d";
	
	private BaseRedisService<String, String, String> rediscluster;
	
	@SuppressWarnings("unchecked")
	public HouseBindCacheUtils(){
		rediscluster = ContextUtil.getContext()
				.getBean("baseRedisServiceImpl", BaseRedisService.class);
	}

	public static HouseBindCacheUtils getInstance() {
		if (instance == null) {
			synchronized (HouseBindCacheUtils.class) {
				if (instance == null) {
					instance = new HouseBindCacheUtils();
				}
			}
		}
		return instance;
	}
	
	/**
	 * 写入缓存
	 * @param messageType
	 * @param messageNo
	 * @param cache
	 * @throws Exception
	 */
	public void addCache(int messageType,long messageNo,HouseBindPolicyCache cache) throws Exception{
		String hashKey = String.format(HOUSE_BIND_CACHE_FIELD_FORMATE, messageType,messageNo);
		rediscluster.putHash(HOUSE_BIND_CACHE_KEY, hashKey, JSON.toJSONString(cache));
	}
	
	/**
	 * 查询缓存
	 * @param messageType
	 * @param messageNo
	 * @throws Exception
	 * @return
	 */
	public HouseBindPolicyCache getCache(int messageType,long messageNo) throws Exception{
		String hashKey = String.format(HOUSE_BIND_CACHE_FIELD_FORMATE, messageType,messageNo);
		String jsonStr = rediscluster.getHash(HOUSE_BIND_CACHE_KEY, hashKey);
		if(StringUtils.isBlank(jsonStr)){
			return null;
		}
		HouseBindPolicyCache cache = JSON.parseObject(jsonStr,HouseBindPolicyCache.class);
		return cache;
	}

	/**
	 * 删除缓存
	 * @param messageType
	 * @param messageNo
	 * @throws Exception
	 */
	public void deleteCache(int messageType,long messageNo) throws Exception{
		String hashKey = String.format(HOUSE_BIND_CACHE_FIELD_FORMATE, messageType,messageNo);
		rediscluster.removeHash(HOUSE_BIND_CACHE_KEY, hashKey);
	}
}
