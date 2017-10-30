package com.luck.kafka;

/**
 * @Author miracle
 * @Date 2017/10/30 0030 9:27
 */
import com.luck.service.TestLocalEventService;
import com.luck.service.TestLocalMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class SendKafkaMsg {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TestLocalMessageService testLocalMessageService;
    @Autowired
    private TestLocalEventService testLocalEventService;
    //发送给localmessage开关
    private boolean enableLocalMessage = true;
    //发送给localevent开关
    private boolean enableLocalEvent = false;

    @Bean
    public String sendToLocalMessage(){
        if (enableLocalMessage){
            testLocalMessageService.sendData2Kafka();
        }else{
            logger.info("enableLocalMessage........................ :{}",enableLocalMessage);
        }
        return "";
    }
    @Bean
    public String sendToLocalEvent(){
        if (enableLocalEvent){
            testLocalEventService.sendData2Kafka();
        }else{
            logger.info("enableLocalEvent........................ :{}",enableLocalEvent);
        }
        return "";
    }
}
