package com.luck.controller;

import com.luck.dto.SendPointEventDto;
import com.luck.dto.SendSpeedEventDto;
import com.luck.dto.SendStatusEventDto;
import com.luck.service.TestLocalEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/sendSpeed")
    public void sendSpeed(SendSpeedEventDto sendSpeedEventDto){
        logger.info("LocaleventController sendSpeed reqeust parm :{}", sendSpeedEventDto.toString());

        testLocalEventService.setQINGQI_COMMAND(sendSpeedEventDto.getQINGQI_COMMAND());
        testLocalEventService.setSpeed(sendSpeedEventDto.getSpeed());
        testLocalEventService.setTerminalId(sendSpeedEventDto.getTerminalId());
        testLocalEventService.setTopic(sendSpeedEventDto.getTopic());

        try {
            testLocalEventService.sendSpeed();
        }catch (Exception e){
            logger.error("LocaleventController sendSpeed error");
            e.printStackTrace();
        }
    }

    @RequestMapping("/sendPoint")
    public void sendPoint(SendPointEventDto sendPointEventDto){
        logger.info("LocaleventController sendPoint reqeust parm :{}", sendPointEventDto.toString());

        testLocalEventService.setQINGQI_COMMAND(sendPointEventDto.getQINGQI_COMMAND());
        testLocalEventService.setTerminalId(sendPointEventDto.getTerminalId());
        testLocalEventService.setTopic(sendPointEventDto.getTopic());

        try {
            testLocalEventService.sendPoint();
        }catch (Exception e){
            logger.error("LocaleventController sendPoint error");
        }
    }
    @RequestMapping("/sendStatus")
    public void sendStatus(SendStatusEventDto sendStatusEventDto){
        logger.info("LocaleventController sendStatus reqeust parm :{}",sendStatusEventDto.toString());

        testLocalEventService.setQINGQI_COMMAND(sendStatusEventDto.getQINGQI_COMMAND());
        testLocalEventService.setTerminalId(sendStatusEventDto.getTerminalId());
        testLocalEventService.setTopic(sendStatusEventDto.getTopic());

        try {
            testLocalEventService.sendStatus();
        }catch (Exception e){
            logger.error("LocaleventController sendStatus error");
        }
    }
}
