package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 14:06
 */
public class SendEventMessageDto extends MessageBaseDto{
    private Long eventSum = 1L;
    private String eventTopic = "localevent-event-test";


    @Override
    public String toString() {
        return "SendEventMessageDto{" +
                "eventSum=" + eventSum +
                ", eventTopic='" + eventTopic + '\'' +
                super.toString()+
                '}';
    }

    public Long getEventSum() {
        return eventSum;
    }

    public void setEventSum(Long eventSum) {
        this.eventSum = eventSum;
    }

    public String getEventTopic() {
        return eventTopic;
    }

    public void setEventTopic(String eventTopic) {
        this.eventTopic = eventTopic;
    }
}
