package com.luck.service;

import com.google.protobuf.ByteString;
import com.luck.dto.SendUnormalEventDto;
import com.luck.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.lc.core.protocol.common.LCLocationData;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author miracle
 * @Date 2017/10/30 0030 9:40
 */
@Service
public class TestLocalEventService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private String QINGQI_COMMAND;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String topic;

    private String terminalId;

    private Integer speed;

    /**
     * 纬度
     */
    private Integer longitude;
    /**
     * 经度
     */
    private Integer latitude;

    /**
     * 车况中 车辆状态
     * 1：启动状态
     * 0：真正熄火状态
     */
    private String carStatus;
    /**
     * 推送localevent 超速报警
     */
    public void sendSpeed() throws Exception{
        //创建pb
        LCLocationData.LocationData.Builder builder = LCLocationData.LocationData.newBuilder();
        //必填数据赋值
        builder = getNeedPb(builder);
        builder.setSpeed(speed);
        LCLocationData.LocationData taLocationData = builder.build();
        //发送消息到kafka
        send2Kafka(taLocationData,terminalId);
        logger.info("TestLocalEventService sendSpeed ..............:{}",System.currentTimeMillis());
    }
    /**
     * 推送localevent 关键点出入
     */
    public void sendPoint() throws Exception{
        //创建pb
        LCLocationData.LocationData.Builder builder = LCLocationData.LocationData.newBuilder();
        //必填数据赋值
        builder = getNeedPb(builder);

        builder.setOriginalLng(longitude);
        builder.setOriginalLat(latitude);

        LCLocationData.LocationData taLocationData = builder.build();
        //发送消息到kafka
        send2Kafka(taLocationData,terminalId);
        logger.info("TestLocalEventService sendPoint ..............:{}", System.currentTimeMillis());

    }
    /**
     * 推送localevent 车况
     */
    public void sendStatus() throws Exception{
        //创建pb
        LCLocationData.LocationData.Builder builder = LCLocationData.LocationData.newBuilder();
        //必填数据赋值
        builder = getNeedPb(builder);
        builder.setStatus(Long.parseLong(carStatus));
        builder.setSpeed(speed);
        LCLocationData.LocationData taLocationData = builder.build();
        //发送消息到kafka
        send2Kafka(taLocationData,terminalId);
        logger.info("TestLocalEventService sendStatus ..............:{}", System.currentTimeMillis());
    }

    /**
     * 推送 急转弯、急加速、急减速
     */
    public void sendUnormal(SendUnormalEventDto sendUnormalEventDto) throws Exception{
        //创建pb
        LCLocationData.LocationData.Builder builder = LCLocationData.LocationData.newBuilder();
        //必填数据赋值
        builder = getNeedPb(builder);
        //附加报警信息
        byte additionAlarmByte = processUnormalAlarm(sendUnormalEventDto);
        byte[] additionAlarmByteArray = {0x00, 0x00, 0x00, 0x00, 0x00, additionAlarmByte, 0x00, 0x00};
        ByteString byteString = ByteString.copyFrom(additionAlarmByteArray);
        builder.setAdditionAlarm(byteString);
        LCLocationData.LocationData taLocationData = builder.build();
        //发送消息到kafka
        send2Kafka(taLocationData,terminalId);
        logger.info("TestLocalEventService sendUnormal ..............:{}", System.currentTimeMillis());
    }

    /**
     * 处理附加报警 并转换为字节（急转弯、急加速、急减速）
     * @param sendUnormalEventDto
     * @return
     */
    private byte processUnormalAlarm(SendUnormalEventDto sendUnormalEventDto){
        /**
         * 0：无任何不正常情况
         * 1: 急加速 rapidAcceleration;
         * 2：急减速 rapidDeceleration;
         * 3：急转弯 sharpTurning;
         * 4：急加速+急转弯
         * 5：急减速+急转弯
         */
        //急加速
        if (1 == sendUnormalEventDto.getType()){
            return 0x02;
        }
        //急减速
        else  if (2 == sendUnormalEventDto.getType()){
            return 0x04;
        }
        //急转弯
        else  if (3 == sendUnormalEventDto.getType()){
            return 0x08;
        }
        //急加速+急转弯
        else  if (4 == sendUnormalEventDto.getType()){
            return 0x0A;
        }
        //急减速+急转弯
        else  if (5 == sendUnormalEventDto.getType()){
            return 0x0C;
        }
        //啥也没有
        else {
            return 0x00;
        }
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
        builder.setGpsDate(System.currentTimeMillis() / 1000);

        byte[] additionAlarmByteArray = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
        ByteString byteString = ByteString.copyFrom(additionAlarmByteArray);
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
            logger.info("---------sended kafak ,topic :{}",topic);
        }catch (Exception e){
            logger.error("send2Kafka error");
            e.printStackTrace();
        }
    }

    public String getQINGQI_COMMAND() {
        return QINGQI_COMMAND;
    }

    public void setQINGQI_COMMAND(String QINGQI_COMMAND) {
        this.QINGQI_COMMAND = QINGQI_COMMAND;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }
}
