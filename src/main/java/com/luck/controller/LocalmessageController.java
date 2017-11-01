package com.luck.controller;

import com.luck.dto.BatchLocalmessageDto;
import com.luck.dto.SendEventDto;
import com.luck.dto.SendPointDto;
import com.luck.dto.SendStatusDto;
import com.luck.service.TestLocalMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author miracle
 * @Date 2017/10/31 0031 14:52
 */
@Controller
@RequestMapping("/localmessage")
public class LocalmessageController {

    @Autowired
    private TestLocalMessageService testLocalMessageService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 批量推送告警、关键点出入、车况
     * @param batchLocalmessageDto
     */
    @RequestMapping("/batchLocalmessage")
    @ResponseBody
    public void batchLocalmessage(BatchLocalmessageDto batchLocalmessageDto){
        logger.info("batchLocalmessage reqeust parm :{}",batchLocalmessageDto.toString());
        try {
            testLocalMessageService.setEventTopic(batchLocalmessageDto.getEventTopic());
            testLocalMessageService.setPointTopic(batchLocalmessageDto.getPointTopic());
            testLocalMessageService.setStatusTopic(batchLocalmessageDto.getStatusTopic());

            testLocalMessageService.setEventSum(batchLocalmessageDto.getEventSum());
            testLocalMessageService.setPointSum(batchLocalmessageDto.getPointSum());
            testLocalMessageService.setStatusSum(batchLocalmessageDto.getStatusSum());

            testLocalMessageService.setSleepTime(batchLocalmessageDto.getSleepTime());

            testLocalMessageService.setMainDriverId(batchLocalmessageDto.getMainDriverId());

            testLocalMessageService.setEventEnable(batchLocalmessageDto.isEventEnable());
            testLocalMessageService.setPointEnable(batchLocalmessageDto.isPointEnable());
            testLocalMessageService.setStatusEnable(batchLocalmessageDto.isStatusEnable());

            testLocalMessageService.setBatch(batchLocalmessageDto.isBatch());

            testLocalMessageService.batchLocalmessage();
        }catch (Exception e){
            logger.error("LocalmessageController batchLocalmessage error");
            e.printStackTrace();
        }
    }

    /**
     * 发送告警
     * @param sendEventDto
     */
    @RequestMapping("/sendEventData")
    @ResponseBody
    public void sendEventData(@RequestBody SendEventDto sendEventDto){
        logger.info("sendEventData reqeust parm :{}",sendEventDto.toString());
        try {
            testLocalMessageService.setEventSum(sendEventDto.getEventSum());
            testLocalMessageService.setEventTopic(sendEventDto.getEventTopic());
            testLocalMessageService.setSleepTime(sendEventDto.getSleepTime());
            testLocalMessageService.setMainDriverId(sendEventDto.getMainDriverId());

            testLocalMessageService.sendEventData();
        }catch (Exception e){
            logger.error("LocalmessageController sendEventData error");
            e.printStackTrace();
        }
    }

    /**
     * 发送关键点
     * @param sendPointDto
     */
    @RequestMapping("/sendPointData")
    @ResponseBody
    public void sendPointData(@RequestBody SendPointDto sendPointDto){
        logger.info("sendPointData reqeust parm :{}",sendPointDto.toString());
        try {
            testLocalMessageService.setPointSum(sendPointDto.getPointSum());
            testLocalMessageService.setPointTopic(sendPointDto.getPointTopic());
            testLocalMessageService.setSleepTime(sendPointDto.getSleepTime());
            testLocalMessageService.setMainDriverId(sendPointDto.getMainDriverId());

            testLocalMessageService.sendPointData();
        }catch (Exception e){
            logger.error("LocalmessageController sendPointData error");
            e.printStackTrace();
        }
    }

    /**
     * 发送车况
     * @param sendStatusDto
     */
    @RequestMapping("/sendStatusData")
    @ResponseBody
    public void sendStatusData(@RequestBody SendStatusDto sendStatusDto){
        logger.info("sendStatusData reqeust parm :{}",sendStatusDto.toString());
        try {
            testLocalMessageService.setStatusSum(sendStatusDto.getStatusSum());
            testLocalMessageService.setStatusTopic(sendStatusDto.getStatusTopic());
            testLocalMessageService.setSleepTime(sendStatusDto.getSleepTime());
            testLocalMessageService.setMainDriverId(sendStatusDto.getMainDriverId());

            testLocalMessageService.sendStatusData();
        }catch (Exception e){
            logger.error("LocalmessageController sendStatusData error");
            e.printStackTrace();
        }
    }
}
