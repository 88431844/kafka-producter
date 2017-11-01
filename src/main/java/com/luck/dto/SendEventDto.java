package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 14:06
 */
public class SendEventDto {
    private Long eventSum = 1L;
    private String eventTopic = "localevent-event-test";
    private Long sleepTime = 500L;
    private String mainDriverId = "2d7206379f3741548c0d17a9999519bf";

    @Override
    public String toString() {
        return "SendEventDto{" +
                "eventSum=" + eventSum +
                ", eventTopic='" + eventTopic + '\'' +
                ", sleepTime=" + sleepTime +
                ", mainDriverId='" + mainDriverId + '\'' +
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
}
