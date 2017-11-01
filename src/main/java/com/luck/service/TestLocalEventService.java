package com.luck.service;

import com.google.protobuf.ByteString;
import com.luck.util.JsonUtil;
import com.luck.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.lc.core.protocol.common.LCLocationData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author miracle
 * @Date 2017/10/30 0030 9:40
 */
@Service
public class TestLocalEventService {

    @Autowired
    private KafkaTemplate kafkaTemplate;
//    @Autowired
//    private StringRedisTemplate redisTemplate;

    private static final String QINGQI_COMMAND = "3002";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 推送超速
     */
    private boolean enableSpeed = true;
//    private boolean enableSpeed = false;
    /**
     * 推送关键点出入
     */
//    private boolean enablePoint = true;
    private boolean enablePoint = false;
    /**
     * 推送车况
     */
//    private boolean enableStatus = true;
    private boolean enableStatus = false;

    private String topic = "jfz_ZHposcan_pkt";

    private String terminalId = "14807431717";


    public void sendData2Kafka() throws Exception {
        logger.info("====================start send to localevent====================");
        long s = System.currentTimeMillis();
        if (enableSpeed) {
            for (int i = 0; i < 10; i++) {
                sendSpeed();
            }
        }

        if (enablePoint) {
            sendPoint();
        }

        if (enableStatus) {
            sendStatus();
        }
        long e = System.currentTimeMillis();
        logger.info("====================end  send to localevent=====cost time :{}===============", (e - s));
    }

    private void sendSpeed() {
        //创建pb
        LCLocationData.LocationData.Builder builder = LCLocationData.LocationData.newBuilder();
        //必填数据赋值
        builder = getNeedPb(builder);
        builder.setSpeed(RandomUtil.getNum(100,200));
        LCLocationData.LocationData taLocationData = builder.build();
        //发送消息到kafka
        send2Kafka(taLocationData,terminalId);
    }

    private void sendPoint() throws Exception{
        //沈阳经纬度 纬度（Longitude）：41.6771800000,经度（Latitude）：123.4631000000
        //大连经纬度 纬度（Longitude）：38.9136900000,经度（Latitude）：121.6147600000
        //滨州经纬度 纬度（Longitude）：37.3821100000,经度（Latitude）：117.9727900000
        //成都经纬度 纬度（Longitude）：30.5702000000,经度（Latitude）：104.0647600000

//        Set<Object> carList = redisTemplate.boundHashOps("car_sync").keys();
//        for (Object o : carList){
//            System.out.println(o.toString());
//        }

        //创建pb
        LCLocationData.LocationData.Builder builder = LCLocationData.LocationData.newBuilder();
        //必填数据赋值
        builder = getNeedPb(builder);

        //随机设置沈阳 大连经纬度(去掉小数点保留小数点后六位)
        if (RandomUtil.getBoolean()){
            //true 为设置沈阳经纬度
            builder.setLongitude(41677180);
            builder.setLatitude(123463100);
            logger.info("---------沈阳经纬度");
        }else{
            //false 为设置大连经纬度
            builder.setLongitude(38913690);
            builder.setLatitude(121614760);
            logger.info("---------大连经纬度");
        }

        LCLocationData.LocationData taLocationData = builder.build();
        //发送消息到kafka
        send2Kafka(taLocationData,terminalId);

    }

    private void sendStatus() {

    }

    /**
     * 填充必要pb结构
     * @param builder
     * @return
     */
    private LCLocationData.LocationData.Builder getNeedPb(LCLocationData.LocationData.Builder builder){
        //必填数据赋值
        builder.setAlarm(0);
        builder.setStatus(0);
        builder.setHeight(0);
        builder.setSpeed(0);
        builder.setDirection(0);
        builder.setReceiveDate(System.currentTimeMillis());
        builder.setIsPatch(false);
        builder.setGpsDate(System.currentTimeMillis());

        ByteString byteString = ByteString.copyFrom("1999999999".getBytes());
        builder.setAdditionAlarm(byteString);
        return  builder;
    }

    /**
     * 发送信息到kafka
     * @param taLocationData
     * @param terminalId
     */
    private void send2Kafka(LCLocationData.LocationData taLocationData,String terminalId){
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("commandId", QINGQI_COMMAND);
        dataMap.put("message", com.mapbar.protobuf.proto.Base64.encode(taLocationData.toByteArray()));

        try {
            kafkaTemplate.send(topic,terminalId, JsonUtil.toJson(dataMap));
        }catch (Exception e){
            logger.error("send2Kafka error");
            e.printStackTrace();
        }
    }
}
