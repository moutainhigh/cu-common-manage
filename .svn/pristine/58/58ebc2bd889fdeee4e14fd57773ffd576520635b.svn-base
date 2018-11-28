package com.aotain.common.utils;

import java.util.HashSet;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPubSub;

public class RedisChannelShow {

	static class ChannelListener extends JedisPubSub {
		@Override
		public void onMessage(String channel, String message) {
			System.out.println("channel:" + channel + "receives message :" + message);
			this.unsubscribe();
		}


		@Override
		public void onSubscribe(String channel, int subscribedChannels) {
			System.out.println("channel:" + channel + "is been subscribed:" + subscribedChannels);
		}
	}
	
	public static void main(String[] args) {
		HashSet<HostAndPort> set = new HashSet<HostAndPort>();
		String[] hosts = "192.168.5.65,192.168.5.66,192.168.5.67,192.168.5.68,192.168.5.69,192.168.5.71".split(",");
		for(String host : hosts){
			set.add(new HostAndPort(host, 7000));
		}
		@SuppressWarnings("resource")
		JedisCluster jedis = new JedisCluster(set);  
		ChannelListener listener = new ChannelListener();  
        jedis.subscribe(listener, "StrategySendChannel");  
	}
}
