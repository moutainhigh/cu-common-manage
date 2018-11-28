package com.aotain.common.utils.kafka;

import java.util.Map;

import com.aotain.common.config.LocalConfig;
import com.aotain.common.utils.model.msg.OtherAckQueue;
import com.aotain.common.utils.tools.CommonConstant;

/**
 * ack队列操作类
 * @author Administrator
 *
 */
public class OtherAckQueueUtil {

	/**
	 * 添加单条消息到ack队列
	 */
	public static void sendMsgToKafkaAckQueue(OtherAckQueue ack) {
	    Map<String, Object> conf = LocalConfig.getInstance().getKafkaProducerConf();
	    
		KafkaProducer producer=new KafkaProducer(conf);
        producer.producer(CommonConstant.KAFKA_QUEUE_NAME_OTHERACK,ack.objectToJson());  
    }
	
	/**
	 * 直接添加一条字符串信息到ack队列
	 * @param message
	 */
	public static void sendMsgToKafkaAckQueue(String message) {
		Map<String, Object> conf = LocalConfig.getInstance().getKafkaProducerConf();
		KafkaProducer producer = new KafkaProducer(conf);
		producer.producer(CommonConstant.KAFKA_QUEUE_NAME_OTHERACK, message);
	}
}
