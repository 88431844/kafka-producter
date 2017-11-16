package com.luck.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author miracle
 * @Date 2017/11/15 0015 17:01
 */
public class KafkaUtil {

    /**
     * 获取KafkaTemplate
     * @param properties
     * @return
     */
    public static KafkaTemplate<String, Object> getKafkaTemplate(Map<String,Object> properties){
        //kafka服务器地址
        String kafkaSever = (String)properties.get("kafkaSever");
        //如果没有配置kafka服务器地址则置为默认服务器
        if (StringUtils.isEmpty(kafkaSever)){
            kafkaSever = "SY-LP1:9092,SY-LP2:9092,SY-LP3:9092";
        }

        //key-value序列化方式
        String keySerializer = (String)properties.get("keySerializer");
        String valueSerializer = (String)properties.get("valueSerializer");
        if (StringUtils.isEmpty(keySerializer)){
            keySerializer = "org.apache.kafka.common.serialization.StringSerializer";
        }
        if (StringUtils.isEmpty(valueSerializer)){
            valueSerializer = "org.apache.kafka.common.serialization.StringSerializer";
        }

        //请求超时时间
        String requestTimeStr = (String)properties.get("requestTime");
        Integer requestTime = 0;
        if (null != requestTimeStr){
            requestTime = Integer.parseInt(requestTimeStr);
        }
        else {
            requestTime = 30000;
        }


        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaSever);
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 1);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 1177600);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, requestTime);

        ProducerFactory<String, Object> producerFactory = new DefaultKafkaProducerFactory<>(props);

        KafkaTemplate<String, Object> kafkaTemplate = new KafkaTemplate<String, Object>(producerFactory);

        return kafkaTemplate;
    }
}
