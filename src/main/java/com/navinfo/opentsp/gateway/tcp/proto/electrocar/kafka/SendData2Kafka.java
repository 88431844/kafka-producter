package com.navinfo.opentsp.gateway.tcp.proto.electrocar.kafka;

import com.navinfo.opentsp.gateway.tcp.proto.electrocar.entity.PushEventRecordEntity;
import com.navinfo.opentsp.gateway.tcp.proto.electrocar.entity.PushPointRecordEntity;
import com.navinfo.opentsp.gateway.tcp.proto.electrocar.entity.PushStatusRecordEntity;
import com.navinfo.opentsp.gateway.tcp.proto.electrocar.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Random;

/**
 *  kakfka生产者
 */
@Component
public class SendData2Kafka {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String eventTopic = "localevent-event-stresstest";
    private String pointTopic = "localevent-point-stresstest";
    private String statusTopic = "localevent-status-stresstest";

    private Long eventSum = 100L;
    private Long pointSum = 100L;
    private Long statusSum = 100L;

    private Long sleepTime = 5000L;

    @PostConstruct
    public void sendData2Kafka() {
        try {
            logger.info("====================start====================");
//            long s1 = System.currentTimeMillis();
//            sendEventData();
//            long e1 = System.currentTimeMillis();
//            logger.info("sendEventData cost time :{}", (e1 - s1));
//
//            long s2 = System.currentTimeMillis();
//            sendPointData();
//            long e2 = System.currentTimeMillis();
//            logger.info("sendPointData cost time :{}", (e2 - s2));

            long s3 = System.currentTimeMillis();
            sendStatusData();
            long e3 = System.currentTimeMillis();
            logger.info("sendStatusData cost time :{}", (e3 - s3));

            logger.info("====================end====================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendEventData() throws Exception {
        for (int i = 0; i < eventSum; i++) {
            PushEventRecordEntity pushEventRecordEntity = new PushEventRecordEntity();
            //TODO 补充Entity
            kafkaTemplate.send(eventTopic, pushEventRecordEntity);
        }
        Thread.sleep(sleepTime);
    }

    private void sendPointData() throws Exception {
        for (int i = 0; i < pointSum; i++) {
            PushPointRecordEntity pushPointRecordEntity = new PushPointRecordEntity();
            //TODO 补充Entity
            kafkaTemplate.send(pointTopic, pushPointRecordEntity);
        }
        Thread.sleep(sleepTime);
    }

    private void sendStatusData() throws Exception {
        for (int i = 0; i < statusSum; i++) {
            PushStatusRecordEntity entity = new PushStatusRecordEntity();

            entity.setAutoTerminalId("autoTerminalId" + i);
            entity.setCarId("carId" + i);
            entity.setCarNumber("carNumber" + i);
            entity.setOwnerId("ownerId" + i);
            entity.setMainDriver("MainDriver" + i);
            entity.setMainDriverName("MainDriverName" + i);
            entity.setMainDriverPhone("MainDriverPhone" + i);
            entity.setSubDriver("SubDriver" + i);
            entity.setSubDriverName("SubDriverName" + i);
            entity.setSubDriverPhone("SubDriverPhone" + i);

            Random random = new Random();
            int tripFlag = random.nextInt(1)%(1-0+1) + 0;

            entity.setType(tripFlag);//0 行程开始
            entity.setDirection(0);
            int travelStatus = random.nextInt(2)%(2-0+2) + 0;
            entity.setTravelStatus(travelStatus);
            if (tripFlag == 0) {//行程开始
                entity.setBeginTime(System.currentTimeMillis());
                entity.setBeginLon(41.6772012272);
                entity.setBeginLat(123.4631317933);
                entity.setBeginSpeed(random.nextInt(100)%(100-0+100) + 0);
            } else {//行程结束
                entity.setBeginTime(System.currentTimeMillis());
                entity.setBeginLon(38.9136755548);
                entity.setBeginLat(121.6147530946);
                entity.setBeginSpeed(random.nextInt(100)%(100-0+100) + 0);
            }

            kafkaTemplate.send(statusTopic,  JsonUtil.toJson(entity));
        }
        Thread.sleep(sleepTime);
    }
}

