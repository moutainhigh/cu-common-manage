package com.aotain.common.utils.kafka;

import java.util.Map;

import com.aotain.common.config.LocalConfig;
import com.aotain.common.utils.model.msg.MessageStatQueue;
import com.aotain.common.utils.tools.CommonConstant;

/**
 * 消息统计队列工具类
 * @author Jason.CW.Cheung
 * @date 2018年3月5日 下午4:09:05
 * @version 1.0
 */
public class MessageStatQueueUtils {
	
	/**
	 * 添加单条消息对象到通知消息队列
	 */
	public static void sendMessage(MessageStatQueue message) {
		Map<String, Object> conf = LocalConfig.getInstance().getKafkaProducerConf();
		KafkaProducer producer = new KafkaProducer(conf);
		producer.producer(CommonConstant.KAFKA_QUEUE_NAME_MESSAGE_STAT, message.objectToJson());
	}
	
	/**
	 * 添加单条消息json string到通知消息队列
	 */
	public static void sendMessage(String messageJsonStr) {
		Map<String, Object> conf = LocalConfig.getInstance().getKafkaProducerConf();
		KafkaProducer producer = new KafkaProducer(conf);
		producer.producer(CommonConstant.KAFKA_QUEUE_NAME_MESSAGE_STAT, messageJsonStr);
	}
	
}
