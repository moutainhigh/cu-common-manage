package com.aotain.cu.serviceapi.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.aotain.cu.serviceapi.model.ServiceAddress;
import com.netflix.appinfo.MyDataCenterInstanceConfig;
import com.netflix.client.ClientFactory;
import com.netflix.config.ConfigurationManager;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;

/**
 * SpringCloud服务地址获取工具
 * 
 * @author liuz@aotian.com
 * @date 2018年8月19日 上午8:58:17
 */
@SuppressWarnings("deprecation")
public class ServiceAddressSelector {
	private static final Logger log = Logger.getLogger(ServiceAddressSelector.class);
	private static RoundRobinRule chooseRule = new RoundRobinRule();

	public static void init(Properties ribbon) {
		try {
			log.info("start init ribbon...");
			ConfigurationManager.loadProperties(ribbon);
			DiscoveryManager.getInstance().initComponent(new MyDataCenterInstanceConfig(),
					new DefaultEurekaClientConfig());
		} catch (Throwable e) {
			log.error("init ribbon exception ", e);
		}
		log.info("complete init ribbon...");
	}

	/**
	 * 根据轮询策略选择一个地址
	 * 
	 * @param clientName ribbon.properties配置文件中配置项的前缀名, 如myclient
	 * @return null表示该服务当前没有可用地址
	 */
	public static ServiceAddress selectOne(String clientName) {
		// ClientFactory.getNamedLoadBalancer会缓存结果, 所以不用担心它每次都会向eureka发起查询
		@SuppressWarnings("rawtypes")
		DynamicServerListLoadBalancer lb = (DynamicServerListLoadBalancer) ClientFactory
				.getNamedLoadBalancer(clientName);
		Server selected = chooseRule.choose(lb, null);
		if (null == selected) {
			log.error("no useful service address : " + clientName);
			return null;
		}
		log.debug("select service result : clientName=" + clientName + ", service=" + selected);
		return new ServiceAddress(selected.getPort(), selected.getHost());
	}

	/**
	 * 选出该服务所有可用地址
	 * 
	 * @param clientName
	 * @return
	 */
	public static List<ServiceAddress> selectAvailableServers(String clientName) {
		@SuppressWarnings("rawtypes")
		DynamicServerListLoadBalancer lb = (DynamicServerListLoadBalancer) ClientFactory
				.getNamedLoadBalancer(clientName);
		List<Server> serverList = lb.getReachableServers();
		if (serverList.isEmpty()) {
			log.error("no useful service address : " + clientName);
			return Collections.emptyList();
		}
		log.debug("select service result : clientName=" + clientName + ", serverList=" + serverList);
		List<ServiceAddress> adressList = new ArrayList<ServiceAddress>();
		for(Server server : serverList){
			adressList.add(new ServiceAddress(server.getPort(), server.getHost()));
		}
		return adressList;
	}
}
