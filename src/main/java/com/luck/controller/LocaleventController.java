package com.luck.controller;

import com.luck.dto.CommonRespondDto;
import com.luck.dto.SendPointEventDto;
import com.luck.dto.SendSpeedEventDto;
import com.luck.dto.SendStatusEventDto;
import com.luck.service.TestLocalEventService;
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
 * @Date 2017/10/31 0031 14:54
 */
@Controller
@RequestMapping("/localevent")

public class LocaleventController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestLocalEventService testLocalEventService;

    /**
     * 发送超速报警
     * @param sendSpeedEventDto
     * @return
     */
    @RequestMapping("/sendSpeed")
    @ResponseBody
    public CommonRespondDto sendSpeed(@RequestBody SendSpeedEventDto sendSpeedEventDto){
        CommonRespondDto commonRespondDto = new CommonRespondDto();
        logger.info("LocaleventController sendSpeed request parm :{}", sendSpeedEventDto.toString());

        testLocalEventService.setQINGQI_COMMAND(sendSpeedEventDto.getQINGQI_COMMAND());
        testLocalEventService.setSpeed(sendSpeedEventDto.getSpeed());
        testLocalEventService.setTerminalId(sendSpeedEventDto.getTerminalId());
        testLocalEventService.setTopic(sendSpeedEventDto.getTopic());

        try {
            testLocalEventService.sendSpeed();
            commonRespondDto.setCode(Const.SUCCESS_CODE);
            commonRespondDto.setMsg(Const.SUCCESS_MSG);
        }catch (Exception e){
            commonRespondDto.setCode(Const.FAIL_CODE);
            commonRespondDto.setMsg(Const.FAIL_MSG);
            logger.error("LocaleventController sendSpeed error");
            e.printStackTrace();
            return commonRespondDto;
        }
        return commonRespondDto;
    }

    /**
     * 发送关键点出入
     * @param sendPointEventDto
     * @return
     */
    @RequestMapping("/sendPoint")
    @ResponseBody
    public CommonRespondDto sendPoint(@RequestBody SendPointEventDto sendPointEventDto){
        CommonRespondDto commonRespondDto = new CommonRespondDto();
        logger.info("LocaleventController sendPoint request parm :{}", sendPointEventDto.toString());

        testLocalEventService.setQINGQI_COMMAND(sendPointEventDto.getQINGQI_COMMAND());
        testLocalEventService.setTerminalId(sendPointEventDto.getTerminalId());
        testLocalEventService.setTopic(sendPointEventDto.getTopic());

        testLocalEventService.setLongitude(sendPointEventDto.getLongitude());
        testLocalEventService.setLatitude(sendPointEventDto.getLatitude());

        try {
            testLocalEventService.sendPoint();
            commonRespondDto.setCode(Const.SUCCESS_CODE);
            commonRespondDto.setMsg(Const.SUCCESS_MSG);
        }catch (Exception e){
            commonRespondDto.setCode(Const.FAIL_CODE);
            commonRespondDto.setMsg(Const.FAIL_MSG);
            logger.error("LocaleventController sendPoint error");
            e.printStackTrace();
            return commonRespondDto;
        }
        return commonRespondDto;
    }

    /**
     * 发送车况
     * @param sendStatusEventDto
     * @return
     */
    @RequestMapping("/sendStatus")
    @ResponseBody
    public CommonRespondDto sendStatus(@RequestBody SendStatusEventDto sendStatusEventDto){
        CommonRespondDto commonRespondDto = new CommonRespondDto();
        logger.info("LocaleventController sendStatus request parm :{}",sendStatusEventDto.toString());

        testLocalEventService.setQINGQI_COMMAND(sendStatusEventDto.getQINGQI_COMMAND());
        testLocalEventService.setTerminalId(sendStatusEventDto.getTerminalId());
        testLocalEventService.setTopic(sendStatusEventDto.getTopic());

        testLocalEventService.setCarStatus(sendStatusEventDto.getCarStatus());
        testLocalEventService.setSpeed(sendStatusEventDto.getSpeed());

        try {
            testLocalEventService.sendStatus();
            commonRespondDto.setCode(Const.SUCCESS_CODE);
            commonRespondDto.setMsg(Const.SUCCESS_MSG);
        }catch (Exception e){
            commonRespondDto.setCode(Const.FAIL_CODE);
            commonRespondDto.setMsg(Const.FAIL_MSG);
            logger.error("LocaleventController sendStatus error");
            e.printStackTrace();
            return commonRespondDto;
        }
        return commonRespondDto;
    }
}
