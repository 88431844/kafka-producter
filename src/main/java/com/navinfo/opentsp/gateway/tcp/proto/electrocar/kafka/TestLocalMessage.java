package com.navinfo.opentsp.gateway.tcp.proto.electrocar.kafka;

import com.navinfo.opentsp.gateway.tcp.proto.electrocar.entity.PushEventRecordEntity;
import com.navinfo.opentsp.gateway.tcp.proto.electrocar.entity.PushPointRecordEntity;
import com.navinfo.opentsp.gateway.tcp.proto.electrocar.entity.PushStatusRecordEntity;
import com.navinfo.opentsp.gateway.tcp.proto.electrocar.util.JsonUtil;
import com.navinfo.opentsp.gateway.tcp.proto.electrocar.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 为了测试localmessage的kakfka生产者
 */
@Component
public class TestLocalMessage {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String eventTopic = "localevent-event-stresstest";
    private String pointTopic = "localevent-point-stresstest";
    private String statusTopic = "localevent-status-stresstest";

    private Long eventSum = 100 * 10000L;
    private Long pointSum = 100 * 10000L;
    private Long statusSum = 100 * 10000L;

//    private Long eventSum = 10L;
//    private Long pointSum = 10L;
//    private Long statusSum = 10L;

    private Long sleepTime = 500L;

    //    private String mainDriverId = "437031bfb41b4ad796e20d45fc5794d5";
    private String mainDriverId = "2d7206379f3741548c0d17a9999519bf";

    private boolean eventEnable = true;
    private boolean pointEnable = true;
    private boolean statusEnable = true;

    @PostConstruct
    public void sendData2Kafka() {
        try {
            long s = System.currentTimeMillis();
            if (eventEnable) {
                logger.info("====================start====================");
                long s1 = System.currentTimeMillis();
                sendEventData();
                long e1 = System.currentTimeMillis();
                logger.info("sendEventData cost time :{} ,product sum :{}", (e1 - s1), eventSum);
            }

            if (pointEnable) {
                long s2 = System.currentTimeMillis();
                sendPointData();
                long e2 = System.currentTimeMillis();
                logger.info("sendPointData cost time :{} ,product sum :{}", (e2 - s2), pointSum);
            }

            if (statusEnable) {
                long s3 = System.currentTimeMillis();
                sendStatusData();
                long e3 = System.currentTimeMillis();
                logger.info("sendStatusData cost time :{} ,product sum :{}", (e3 - s3), statusSum);
            }
            long e = System.currentTimeMillis();
            logger.info("====================end=====cost time :{}===============", (e - s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendEventData() throws Exception {
        for (long i = 0; i < eventSum; i++) {
            PushEventRecordEntity entity = new PushEventRecordEntity();

            entity.setAutoTerminalId(String.valueOf(RandomUtil.getNum(1302872694, 549188823)));
            entity.setCarId(String.valueOf(RandomUtil.getNum(12260, 82169)));
            entity.setCarNumber("辽A" + RandomUtil.getNum(12345, 88888));
            entity.setOwnerId("");
            entity.setMainDriver(mainDriverId);
            entity.setMainDriverName(RandomUtil.getChineseName());
            entity.setMainDriverPhone(RandomUtil.getTel());
            entity.setSubDriver("");
            entity.setSubDriverName("");
            entity.setSubDriverPhone("");

            entity.setType(RandomUtil.getNum(1, 2));
            entity.setBeginTime(System.currentTimeMillis());
            entity.setBeginLon(41.6772012272);
            entity.setBeginLat(123.4631317933);

            entity.setBeginSpeed(RandomUtil.getNum(0, 100));
            entity.setInstantOil(Double.parseDouble(String.valueOf(RandomUtil.getNum(0, 100))));
            entity.setDifferOil(Double.parseDouble(String.valueOf(RandomUtil.getNum(0, 100))));
            entity.setPosition(RandomUtil.getRoad());
            entity.setDescription("Description" + i);
            entity.setDirection(RandomUtil.getNum(0, 3));
            entity.setTravelStatus(RandomUtil.getNum(0, 3));
            kafkaTemplate.send(eventTopic, entity.getAutoTerminalId(),JsonUtil.toJson(entity));
        }
        Thread.sleep(sleepTime);
    }

    private void sendPointData() throws Exception {
        for (long i = 0; i < pointSum; i++) {
            PushPointRecordEntity outRecord = new PushPointRecordEntity();
            outRecord.setAutoTerminalId(String.valueOf(RandomUtil.getNum(1302872694, 549188823)));
            outRecord.setCarId(String.valueOf(RandomUtil.getNum(12260, 82169)));
            outRecord.setCarNumber("辽A" + RandomUtil.getNum(12345, 88888));
            outRecord.setOwnerId("");
            outRecord.setMainDriver(mainDriverId);
            outRecord.setMainDriverName(RandomUtil.getChineseName());
            outRecord.setMainDriverPhone(RandomUtil.getTel());
            outRecord.setSubDriver("");
            outRecord.setSubDriverName("");
            outRecord.setSubDriverPhone("");
            outRecord.setCityCode("0" + RandomUtil.getNum(10, 35));
            outRecord.setCityName("沈阳");
            outRecord.setInOut(1);
            outRecord.setBeginTime(System.currentTimeMillis());
            outRecord.setBeginLon(RandomUtil.getLonLat());
            outRecord.setBeginLat(RandomUtil.getLonLat());
            outRecord.setBeginSpeed(RandomUtil.getNum(0, 100));
            outRecord.setStartTime(0L);
            outRecord.setPosition(RandomUtil.getRoad());
            outRecord.setTripLength(Double.parseDouble(String.valueOf(RandomUtil.getNum(0, 100))));
            outRecord.setInstantOil(Double.parseDouble(String.valueOf(RandomUtil.getNum(0, 100))));
            outRecord.setDescription("驶出");
            outRecord.setDirection(RandomUtil.getNum(0, 3));
            outRecord.setTravelStatus(RandomUtil.getNum(0, 3));
            kafkaTemplate.send(pointTopic, outRecord.getAutoTerminalId(),JsonUtil.toJson(outRecord));
        }
        Thread.sleep(sleepTime);
    }

    private void sendStatusData() throws Exception {
        for (long i = 0; i < statusSum; i++) {
            PushStatusRecordEntity entity = new PushStatusRecordEntity();

            entity.setAutoTerminalId(String.valueOf(RandomUtil.getNum(1302872694, 549188823)));
            entity.setCarId(String.valueOf(RandomUtil.getNum(12260, 82169)));
            entity.setCarNumber("辽A" + RandomUtil.getNum(12345, 88888));
            entity.setOwnerId("");
            entity.setMainDriver(mainDriverId);
            entity.setMainDriverName(RandomUtil.getChineseName());
            entity.setMainDriverPhone(RandomUtil.getTel());
            entity.setSubDriver("");
            entity.setSubDriverName("");
            entity.setSubDriverPhone("");

            int tripFlag = RandomUtil.getNum(0, 1);

            entity.setType(RandomUtil.getNum(0, 1));//0 行程开始
            entity.setDirection(0);
            int travelStatus = RandomUtil.getNum(0, 2);
            entity.setTravelStatus(travelStatus);
            if (tripFlag == 0) {//行程开始
                entity.setBeginTime(System.currentTimeMillis());
                entity.setBeginLon(RandomUtil.getLonLat());
                entity.setBeginLat(RandomUtil.getLonLat());
                entity.setBeginSpeed(RandomUtil.getNum(0, 100));
            } else {//行程结束
                entity.setBeginTime(System.currentTimeMillis());
                entity.setBeginLon(RandomUtil.getLonLat());
                entity.setBeginLat(RandomUtil.getLonLat());
                entity.setBeginSpeed(RandomUtil.getNum(0, 100));
            }

            kafkaTemplate.send(statusTopic,entity.getAutoTerminalId(), JsonUtil.toJson(entity));
        }
        Thread.sleep(sleepTime);
    }


}
