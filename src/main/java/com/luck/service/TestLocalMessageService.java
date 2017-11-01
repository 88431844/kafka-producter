package com.luck.service;

import com.luck.entity.PushEventRecordEntity;
import com.luck.entity.PushPointRecordEntity;
import com.luck.entity.PushStatusRecordEntity;
import com.luck.util.JsonUtil;
import com.luck.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author miracle
 * @Date 2017/10/30 0030 9:28
 */
@Service
public class TestLocalMessageService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    private String eventTopic = "localevent-event-stresstest0925";
//    private String pointTopic = "localevent-point-stresstest0925";
//    private String statusTopic = "localevent-status-stresstest0925";

//    private String eventTopic = "localevent-event-stresstest0920";
//    private String pointTopic = "localevent-point-stresstest0920";
//    private String statusTopic = "localevent-status-stresstest0920";

//    private String eventTopic = "localevent-event-stresstest";
//    private String pointTopic = "localevent-point-stresstest";
//    private String statusTopic = "localevent-status-stresstest";

//    private String eventTopic = "localevent-event-test";
//    private String pointTopic = "localevent-point-test";
//    private String statusTopic = "localevent-status-test";

    private String eventTopic;
    private String pointTopic;
    private String statusTopic;

//    private Long eventSum = 2000 * 10000L;
//    private Long pointSum = 2000 * 10000L;
//    private Long statusSum = 2000 * 10000L;

//    private Long eventSum = 100L;
//    private Long pointSum = 100L;
//    private Long statusSum = 100L;

//    private Long eventSum = 1L;
//    private Long pointSum = 1L;
//    private Long statusSum = 1L;
    private Long eventSum;
    private Long pointSum;
    private Long statusSum;

//    private Long sleepTime = 500L;
    private Long sleepTime;

    //        private String mainDriverId = "437031bfb41b4ad796e20d45fc5794d5";
//    private String mainDriverId = "2d7206379f3741548c0d17a9999519bf";
    private String mainDriverId;
//    private String mainDriverId = "";

//    private boolean eventEnable = false;
//    private boolean pointEnable = true;
//    private boolean statusEnable = false;

//    private boolean eventEnable = true;
//    private boolean pointEnable = true;
//    private boolean statusEnable = true;

//    private boolean eventEnable = true;
//    private boolean pointEnable = false;
//    private boolean statusEnable = false;

//    private boolean eventEnable = false;
//    private boolean pointEnable = false;
//    private boolean statusEnable = true;

    private boolean eventEnable;
    private boolean pointEnable;
    private boolean statusEnable;

    private boolean batch = false;

    /**
     * 批量推送告警、关键点出入、车况
     */
    public void batchLocalmessage() {
        try {
            long s = System.currentTimeMillis();
            if (eventEnable) {
                logger.info("====================start send to localmessage====================");
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
            logger.info("====================end  send to localmessage=====cost time :{}===============", (e - s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送告警到kafka
     * @throws Exception
     */
    public void sendEventData() throws Exception {
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
            //设置管理员id
            entity.setManagerIds(RandomUtil.getManagerList(100, 900, 10));
            //设置最大速度
            entity.setMaxSpeed(RandomUtil.getNum(0, 100));
            kafkaTemplate.send(eventTopic, entity.getAutoTerminalId(), JsonUtil.toJson(entity));
            if (!batch){
                logger.info("evnet send .................{}",System.currentTimeMillis());
            }
        }
        Thread.sleep(sleepTime);
    }

    /**
     * 发送关键点到kafka
     * @throws Exception
     */
    public void sendPointData() throws Exception {
        for (long i = 0; i < pointSum; i++) {
            PushPointRecordEntity entity = new PushPointRecordEntity();
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
            entity.setCityCode("0" + RandomUtil.getNum(10, 35));
            entity.setCityName("沈阳");
            entity.setInOut(1);
            entity.setBeginTime(System.currentTimeMillis());
            entity.setBeginLon(RandomUtil.getLonLat());
            entity.setBeginLat(RandomUtil.getLonLat());
            entity.setBeginSpeed(RandomUtil.getNum(0, 100));
            entity.setStartTime(0L);
            entity.setPosition(RandomUtil.getRoad());
            entity.setTripLength(Double.parseDouble(String.valueOf(RandomUtil.getNum(0, 100))));
            entity.setInstantOil(Double.parseDouble(String.valueOf(RandomUtil.getNum(0, 100))));
            entity.setDescription("驶出");
            entity.setDirection(RandomUtil.getNum(0, 3));
            entity.setTravelStatus(RandomUtil.getNum(0, 3));
            //设置管理员id
            entity.setManagerIds(RandomUtil.getManagerList(100, 900, 10));
            kafkaTemplate.send(pointTopic, entity.getAutoTerminalId(), JsonUtil.toJson(entity));
            if (!batch){
                logger.info("point send .................{}",System.currentTimeMillis());
            }
        }
        Thread.sleep(sleepTime);
    }

    /**
     * 发送车况到kafka
     * @throws Exception
     */
    public void sendStatusData() throws Exception {
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
            //设置管理员id
            entity.setManagerIds(RandomUtil.getManagerList(100, 900, 10));
            kafkaTemplate.send(statusTopic, entity.getAutoTerminalId(), JsonUtil.toJson(entity));
            if (!batch){
                logger.info("status send .................{}",System.currentTimeMillis());
            }
        }
        Thread.sleep(sleepTime);
    }

    public String getEventTopic() {
        return eventTopic;
    }

    public void setEventTopic(String eventTopic) {
        this.eventTopic = eventTopic;
    }

    public String getPointTopic() {
        return pointTopic;
    }

    public void setPointTopic(String pointTopic) {
        this.pointTopic = pointTopic;
    }

    public String getStatusTopic() {
        return statusTopic;
    }

    public void setStatusTopic(String statusTopic) {
        this.statusTopic = statusTopic;
    }

    public Long getEventSum() {
        return eventSum;
    }

    public void setEventSum(Long eventSum) {
        this.eventSum = eventSum;
    }

    public Long getPointSum() {
        return pointSum;
    }

    public void setPointSum(Long pointSum) {
        this.pointSum = pointSum;
    }

    public Long getStatusSum() {
        return statusSum;
    }

    public void setStatusSum(Long statusSum) {
        this.statusSum = statusSum;
    }

    public Long getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Long sleepTime) {
        this.sleepTime = sleepTime;
    }

    public String getMainDriverId() {
        return mainDriverId;
    }

    public void setMainDriverId(String mainDriverId) {
        this.mainDriverId = mainDriverId;
    }

    public boolean isEventEnable() {
        return eventEnable;
    }

    public void setEventEnable(boolean eventEnable) {
        this.eventEnable = eventEnable;
    }

    public boolean isPointEnable() {
        return pointEnable;
    }

    public void setPointEnable(boolean pointEnable) {
        this.pointEnable = pointEnable;
    }

    public boolean isStatusEnable() {
        return statusEnable;
    }

    public void setStatusEnable(boolean statusEnable) {
        this.statusEnable = statusEnable;
    }

    public boolean isBatch() {
        return batch;
    }

    public void setBatch(boolean batch) {
        this.batch = batch;
    }
}
