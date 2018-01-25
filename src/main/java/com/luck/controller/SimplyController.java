package com.luck.controller;

import com.luck.dto.CommonRespondDto;
import com.luck.dto.SendStringDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gzh on 2018/1/25 0025.
 */
@RestController
@RequestMapping("/SimplyController")
public class SimplyController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 发送字符串到指定topic
     * @param dto
     * @return
     */
    @RequestMapping("/sendString")
    public CommonRespondDto sendString(@RequestBody SendStringDto dto){
        CommonRespondDto commonRespondDto = new CommonRespondDto();
        logger.info("SimplyController sendString request parm :{}",dto.toString());
        String topic = dto.getSendTopic();
        String str = dto.getSendStr();
        if (null != topic && null != str && !"".equals(topic) && !"".equals(str)){
            kafkaTemplate.send(topic,str);
        }
        return commonRespondDto;
    }
}
