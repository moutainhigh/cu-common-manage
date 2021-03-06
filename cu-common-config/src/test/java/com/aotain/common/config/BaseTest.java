package com.aotain.common.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.aotain.common.config.dao.IdcJcdmJkcsMapper;
import com.aotain.common.config.model.ClusterHouses;
import com.aotain.common.config.model.IdcHouses;
import com.aotain.common.config.model.IdcJcdmJkcs;
import com.aotain.common.config.redis.BaseRedisDao;
import com.aotain.common.config.redis.BaseRedisService;

/**
 * 
 * @author daiyh@aotain.com
 * @date 2017/11/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-base.xml" })
public class BaseTest {

	public static final Logger logger = Logger.getLogger(BaseTest.class);
	
	private ApplicationContext applicationContext;
	
	@Autowired
    private BaseRedisDao baseRedisDao;

    @Autowired
    private BaseRedisService<String, String, String> baseRedisServiceImpl;

    @Autowired
    private IdcJcdmJkcsMapper idcJcdmJkcsMapper;
    
    private static final String IDC_JDCM_JKCS_CONFIG = "idc_jdcm_jkcs_config";
	
	private static final String KEY_IDC_HOUSES = "IdcHouses";
	
	private static final String KEY_CLUSTER_HOUSE = "ClusterHouseConfiguration";

	@PostConstruct
	public void init() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-base.xml");
	}
	
	@Test
	@Rollback(false)
	public void test() {
		applicationContext.getApplicationName();
		BasicDataSource basicDataSource = applicationContext.getBean("dataSource", BasicDataSource.class);
		RedisTemplate redisTemplate = applicationContext.getBean("redisTemplate", RedisTemplate.class);
		SqlSessionFactory sqlSessionFactory = applicationContext.getBean("sqlSessionFactory",SqlSessionFactory.class);
		DataSourceTransactionManager dataSourceTransactionManager = applicationContext.getBean("transactionManager",DataSourceTransactionManager.class);
		System.out.println("dataSourceTransactionManager="+dataSourceTransactionManager);
		System.out.println(redisTemplate + "==========");
		System.out.println(basicDataSource + "==========");
		System.out.println(sqlSessionFactory+"========");
//		redisTemplate.opsForHash().put("somekey1", "bang", "daiyuhang");
		System.out.println("=====ok");
	}
	
	@Test
	@Rollback(false)
	public void testInitConfig() {
		//initConfiguration();
		//initIdcHouses();
		System.out.println("getClusterId:" + LocalConfig.getInstance().getClusterId());
		System.out.println("getClusterId:" + LocalConfig.getInstance().getHashValueByHashKey("ud1.customer.threadnum"));
		
		/*String idcId = "A2.B1.B2-20090001dsads";
		Map<String, IdcHouses> allHouse = LocalConfig.getInstance().getAllIdcHouses();
		Iterator<String> it = allHouse.keySet().iterator();
		while (it.hasNext()) {
			String houseIdStr = it.next();
			IdcHouses idcHouse = allHouse.get(houseIdStr);
			idcId = idcHouse.getIdcId();
			break;
		}
		System.out.println("idcId:" + idcId);*/
		
//		System.out.println(LocalConfig.getInstance().getAzkabanUrlByHouseIdStr("GD_ATKJ_IDC"));
//		System.out.println(LocalConfig.getInstance().getNameNodeInfoByHouseIdStr("GD_ATKJ_IDC"));
	}
	
	@Test
	@Rollback(false)
	public void testGet() {
		logger.info("testGet start....");
		IdcHouses house = LocalConfig.getInstance().getIdcHouse("GD_ATKJ_IDC");
		System.out.println("house.getHouseIdStr():" + house.getHouseIdStr());
		System.out.println(JSON.toJSONString(house));
		
		/*Map<String, IdcHouses> houses = LocalConfig.getInstance().getAllIdcHouses();
		Iterator<String> it = houses.keySet().iterator();
		while (it.hasNext()) {
			String houseIdStr = it.next();
			IdcHouses idcHouses = houses.get(houseIdStr);
			
			System.out.println("houseIdStr:" + houseIdStr + ",idcHouses:" + JSON.toJSONString(idcHouses));
		} */
		System.out.println("=====1:" + JSON.toJSONString(LocalConfig.getInstance().getAllIdcHouses(null)));
		System.out.println("=====2:" + JSON.toJSONString(LocalConfig.getInstance().getAllIdcHouses(false)));
		System.out.println("=====3:" + JSON.toJSONString(LocalConfig.getInstance().getAllIdcHouses(true)));
	}
	
	private void initClusterHouseConfiguration() {
		List<ClusterHouses> clusterHouses = idcJcdmJkcsMapper.selectClusterHouses();
		if (clusterHouses == null) {
			return;
		}
		Map<String, String> resultMap = new HashMap<String, String>();
		// 将查询的配置信息保存到redis中
		for (ClusterHouses house : clusterHouses) {
			Integer clusterId = house.getClusterId();
			resultMap.put(clusterId + "", JSON.toJSONString(house));
		}
		baseRedisDao.saveHashes(KEY_CLUSTER_HOUSE, resultMap);
	}

	private void initIdcHouses() {
		List<IdcHouses> idcHouses = idcJcdmJkcsMapper.selectIdcHouses();
		if (idcHouses == null) {
			return;
		}
		// 将查询的配置信息保存到redis中
		Map<String, String> resultMap = new HashMap<String, String>();
		for (IdcHouses house : idcHouses) {
			resultMap.put(house.getHouseIdStr(), JSON.toJSONString(house));
		}
		baseRedisDao.saveHashes(KEY_IDC_HOUSES, resultMap);
	}

	private void initConfiguration() {
		List<IdcJcdmJkcs> idcJcdmJkcsList = idcJcdmJkcsMapper.selectConfig();
		if (idcJcdmJkcsList.isEmpty()) {
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
			baseRedisServiceImpl.putHash(IDC_JDCM_JKCS_CONFIG, key, value);
		}
	}

	@Test
	public void testSystem(){
		String value = System.getProperty("user.dir");
		System.out.println("value="+value);
	}

	@Test
	public void testZSet() {
		boolean result = baseRedisServiceImpl.addZSet("StrategySorted_1_15","messageNo_1",50L);
		System.out.println("====ok====="+result);
		long removeZSet = baseRedisServiceImpl.removeZSet("StrategySorted_1_15","messageNo_1");
		System.out.println(removeZSet+"======");
	}
	
	@Test
    public void testDemo(){
        baseRedisServiceImpl.putHash("aotainConfig","cs_key","cs_value");
        System.out.println("=====");
    }
	
}
