package com.luck.test;

import com.luck.entity.PushStatusRecordEntity;
import com.luck.util.JsonUtil;
import com.luck.util.KafkaUtil;
import com.luck.util.RandomUtil;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author miracle
 * @Date 2017/11/15 0015 16:45
 */
public class TestKafka {
    public static void main(String[] args) {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "SY-LP1:9092,SY-LP2:9092,SY-LP3:9092");
//        props.put(ProducerConfig.RETRIES_CONFIG, 0);
//        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 1);
//        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
//        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 1177600);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
//        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 30000);
//
//        ProducerFactory<String, Object> producerFactory = new DefaultKafkaProducerFactory<>(props);
//
//        KafkaTemplate<String, Object> kafkaTemplate = new KafkaTemplate<String, Object>(producerFactory);
        Map<String,Object> properties = new HashMap<>();
        KafkaTemplate<String, Object> kafkaTemplate = KafkaUtil.getKafkaTemplate(properties);

        PushStatusRecordEntity entity = new PushStatusRecordEntity();

        entity.setAutoTerminalId(String.valueOf(RandomUtil.getNum(1302872694, 549188823)));
        entity.setCarId(String.valueOf(RandomUtil.getNum(12260, 82169)));
        entity.setCarNumber("辽A" + RandomUtil.getNum(12345, 88888));
        entity.setOwnerId("");
        entity.setMainDriver("2d7206379f3741548c0d17a9999519bf");
        entity.setMainDriverName(RandomUtil.getChineseName());
        entity.setMainDriverPhone(RandomUtil.getTel());
        entity.setSubDriver("");
        entity.setSubDriverName("");
        entity.setSubDriverPhone("");

        int tripFlag = RandomUtil.getNum(0, 1);

        /**
         * 0 行程开始
         */
        entity.setType(RandomUtil.getNum(0, 1));
        entity.setDirection(0);
        int travelStatus = RandomUtil.getNum(0, 2);
        entity.setTravelStatus(travelStatus);
        /**
         * 行程开始
         */
        if (tripFlag == 0) {
            entity.setBeginTime(System.currentTimeMillis());
            entity.setBeginLon(RandomUtil.getLonLat());
            entity.setBeginLat(RandomUtil.getLonLat());
            entity.setBeginSpeed(RandomUtil.getNum(0, 100));
        }
        /**
         * 行程结束
         */
        else {
            entity.setBeginTime(System.currentTimeMillis());
            entity.setBeginLon(RandomUtil.getLonLat());
            entity.setBeginLat(RandomUtil.getLonLat());
            entity.setBeginSpeed(RandomUtil.getNum(0, 100));
        }
        //设置管理员id
        entity.setManagerIds(RandomUtil.getManagerList(100, 900, 10));
        try{
            kafkaTemplate.send("localevent-status-stresstest", entity.getAutoTerminalId(), JsonUtil.toJson(entity));
            System.out.println("--------------------send kafka");
            Thread.sleep(10);
            System.out.println("--------------------sleep done");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
