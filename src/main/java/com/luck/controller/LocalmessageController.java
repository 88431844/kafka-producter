package com.luck.controller;

import com.luck.dto.*;
import com.luck.service.TestLocalMessageService;
import com.luck.util.Const;
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
    public CommonRespondDto batchLocalmessage(@RequestBody BatchLocalmessageDto batchLocalmessageDto){
        CommonRespondDto commonRespondDto = new CommonRespondDto();
        logger.info("LocalmessageController batchLocalmessage request parm :{}",batchLocalmessageDto.toString());
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
            commonRespondDto.setCode(Const.SUCCESS_CODE);
            commonRespondDto.setMsg(Const.SUCCESS_MSG);
        }catch (Exception e){
            commonRespondDto.setCode(Const.FAIL_CODE);
            commonRespondDto.setMsg(Const.FAIL_MSG);
            logger.error("LocalmessageController LocalmessageController batchLocalmessage error");
            e.printStackTrace();
            return commonRespondDto;
        }
        return commonRespondDto;
    }

    /**
     * 发送告警
     * @param sendEventDto
     */
    @RequestMapping("/sendEventData")
    @ResponseBody
    public CommonRespondDto sendEventData(@RequestBody SendEventMessageDto sendEventDto){
        CommonRespondDto commonRespondDto = new CommonRespondDto();
        logger.info("LocalmessageController sendEventData request parm :{}",sendEventDto.toString());
        try {
            testLocalMessageService.setEventSum(sendEventDto.getEventSum());
            testLocalMessageService.setEventTopic(sendEventDto.getEventTopic());
            testLocalMessageService.setSleepTime(sendEventDto.getSleepTime());
            testLocalMessageService.setMainDriverId(sendEventDto.getMainDriverId());

            testLocalMessageService.sendEventData();
            commonRespondDto.setCode(Const.SUCCESS_CODE);
            commonRespondDto.setMsg(Const.SUCCESS_MSG);
        }catch (Exception e){
            commonRespondDto.setCode(Const.FAIL_CODE);
            commonRespondDto.setMsg(Const.FAIL_MSG);
            logger.error("LocalmessageController LocalmessageController sendEventData error");
            e.printStackTrace();
            return commonRespondDto;
        }
        return commonRespondDto;
    }

    /**
     * 发送关键点
     * @param sendPointDto
     */
    @RequestMapping("/sendPointData")
    @ResponseBody
    public CommonRespondDto sendPointData(@RequestBody SendPointMessageDto sendPointDto){
        CommonRespondDto commonRespondDto = new CommonRespondDto();
        logger.info("LocalmessageController sendPointData request parm :{}",sendPointDto.toString());
        try {
            testLocalMessageService.setPointSum(sendPointDto.getPointSum());
            testLocalMessageService.setPointTopic(sendPointDto.getPointTopic());
            testLocalMessageService.setSleepTime(sendPointDto.getSleepTime());
            testLocalMessageService.setMainDriverId(sendPointDto.getMainDriverId());

            testLocalMessageService.sendPointData();
            commonRespondDto.setCode(Const.SUCCESS_CODE);
            commonRespondDto.setMsg(Const.SUCCESS_MSG);
        }catch (Exception e){
            commonRespondDto.setCode(Const.FAIL_CODE);
            commonRespondDto.setMsg(Const.FAIL_MSG);
            logger.error("LocalmessageController LocalmessageController sendPointData error");
            e.printStackTrace();
            return commonRespondDto;
        }
        return commonRespondDto;
    }

    /**
     * 发送车况
     * @param sendStatusDto
     */
    @RequestMapping("/sendStatusData")
    @ResponseBody
    public CommonRespondDto sendStatusData(@RequestBody SendStatusMessageDto sendStatusDto){
        CommonRespondDto commonRespondDto = new CommonRespondDto();
        logger.info("LocalmessageController sendStatusData request parm :{}",sendStatusDto.toString());
        try {
            testLocalMessageService.setStatusSum(sendStatusDto.getStatusSum());
            testLocalMessageService.setStatusTopic(sendStatusDto.getStatusTopic());
            testLocalMessageService.setSleepTime(sendStatusDto.getSleepTime());
            testLocalMessageService.setMainDriverId(sendStatusDto.getMainDriverId());

            testLocalMessageService.sendStatusData();
            commonRespondDto.setCode(Const.SUCCESS_CODE);
            commonRespondDto.setMsg(Const.SUCCESS_MSG);
        }catch (Exception e){
            commonRespondDto.setCode(Const.FAIL_CODE);
            commonRespondDto.setMsg(Const.FAIL_MSG);
            logger.error("LocalmessageController LocalmessageController sendStatusData error");
            e.printStackTrace();
            return commonRespondDto;
        }
        return commonRespondDto;
    }
}
