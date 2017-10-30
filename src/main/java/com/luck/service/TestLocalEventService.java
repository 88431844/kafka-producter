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

import javax.annotation.PostConstruct;

/**
 * @Author miracle
 * @Date 2017/10/30 0030 9:40
 */
@Service
public class TestLocalEventService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sendData2Kafka() {

    }
}
