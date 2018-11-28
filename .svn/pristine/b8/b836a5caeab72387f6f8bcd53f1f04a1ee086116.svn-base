package com.aotain.common.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.aotain.common.config.dao.IdcJcdmJkcsMapper;
import com.aotain.common.config.model.ClusterHouses;
import com.aotain.common.config.model.IdcHouses;
import com.aotain.common.config.model.IdcJcdmJkcs;
import com.aotain.common.config.redis.BaseRedisService;

/**
 * 将数据库中的配置信息保存到redis中
 * 
 * @author daiyh@aotain.com
 * @date 2017/11/14
 */
@Repository
public class ConfigInitialingBean {

	public static final Logger configLog = Logger.getLogger(ConfigInitialingBean.class);

	@Autowired
	private IdcJcdmJkcsMapper idcJcdmJkcsMapper;

	@Autowired
	private BaseRedisService<String, String, String> baseRedisService;

	private static final String IDC_JDCM_JKCS_CONFIG = "idc_jdcm_jkcs_config";

	private static final String KEY_IDC_HOUSES = "IdcHouses";

	private static final String KEY_CLUSTER_HOUSE = "ClusterHouseConfiguration";

	// 初始化时将数据库配置信息写入redis缓存中
	@PostConstruct
	public void initConfig() {
		configLog.info("Initialize the system configuration start....");
		try {
			initConfiguration();
			initIdcHouses();
			initClusterHouseConfiguration();
		} catch (Exception e) {
			configLog.info("Initialize the system configuration start exception ....",e);
		}
	}

	private void initClusterHouseConfiguration() {
		configLog.info("Initialize the cluster-house configuration start....");
		List<ClusterHouses> clusterHouses = idcJcdmJkcsMapper.selectClusterHouses();
		if (clusterHouses == null) {
			configLog.info("There is no data in the table [idc_jcdm_jqpz] or the idcName is not matched with each other!");
			return;
		}
		Map<String, String> resultMap = new HashMap<String, String>();
		// 将查询的配置信息保存到redis中
		for (ClusterHouses house : clusterHouses) {
			Integer clusterId = house.getClusterId();
			resultMap.put(clusterId + "", JSON.toJSONString(house));
		}
		baseRedisService.putAllHash(KEY_CLUSTER_HOUSE, resultMap);
		configLog.info("Initialize the cluster-house configuration end....");
	}

	private void initIdcHouses() {
		configLog.info("Initialize the [IdcHouses] configuration start....");
		List<IdcHouses> idcHouses = idcJcdmJkcsMapper.selectIdcHouses();
		if (idcHouses == null) {
			configLog.info("There is no data in the table [idc_isms_base_house] or the houses are not reported to SMMS!");
			return;
		}
		// 将查询的配置信息保存到redis中
		Map<String, String> resultMap = new HashMap<String, String>();
		for (IdcHouses house : idcHouses) {
			resultMap.put(house.getHouseIdStr(), JSON.toJSONString(house));
		}
		baseRedisService.putAllHash(KEY_IDC_HOUSES, resultMap);
		configLog.info("Initialize the [IdcHouses] configuration end....");
	}

	private void initConfiguration() {
		configLog.info("Initialize the idc_jcdm_jkcs configuration start....");
		List<IdcJcdmJkcs> idcJcdmJkcsList = idcJcdmJkcsMapper.selectConfig();
		if (idcJcdmJkcsList.isEmpty()) {
			configLog.info("There is no data in the table [idc_jcdm_jkcs]!");
			return;
		}
		// 将查询的配置信息保存到redis中
		for (IdcJcdmJkcs idcJcdmJkcs : idcJcdmJkcsList) {
			String key, value = null;
			String type = idcJcdmJkcs.getType();
			if (type != null) {
				key = type;
				value = idcJcdmJkcs.getCsKey();
			} else {
				key = idcJcdmJkcs.getCsKey();
				value = idcJcdmJkcs.getCsValue() == null ? "undefined" : idcJcdmJkcs.getCsValue();
			}
			baseRedisService.putHash(IDC_JDCM_JKCS_CONFIG, key, value);
		}
		configLog.info("Initialize the idc_jcdm_jkcs configuration end....");

	}

}
