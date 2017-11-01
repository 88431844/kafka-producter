package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 14:19
 */
public class BatchLocalmessageDto {

    private String eventTopic = "localevent-event-test";
    private String pointTopic = "localevent-point-test";
    private String statusTopic = "localevent-status-test";

    private Long eventSum = 1L;
    private Long pointSum = 1L;
    private Long statusSum = 1L;

    private Long sleepTime = 500L;

    private String mainDriverId = "2d7206379f3741548c0d17a9999519bf";

    private boolean eventEnable = false;
    private boolean pointEnable = false;
    private boolean statusEnable = false;

    private boolean batch = false;

    @Override
    public String toString() {
        return "BatchLocalmessageDto{" +
                "eventTopic='" + eventTopic + '\'' +
                ", pointTopic='" + pointTopic + '\'' +
                ", statusTopic='" + statusTopic + '\'' +
                ", eventSum=" + eventSum +
                ", pointSum=" + pointSum +
                ", statusSum=" + statusSum +
                ", sleepTime=" + sleepTime +
                ", mainDriverId='" + mainDriverId + '\'' +
                ", eventEnable=" + eventEnable +
                ", pointEnable=" + pointEnable +
                ", statusEnable=" + statusEnable +
                ", batch=" + batch +
                '}';
    }

    public String getEventTopic() {
        return eventTopic;
    }

    public void setEventTopic(String eventTopic) {
        this.eventTopic = eventTopic;
    }

    public String getPointTopic() {
        return pointTopic;
    }

    public void setPointTopic(String pointTopic) {
        this.pointTopic = pointTopic;
    }

    public String getStatusTopic() {
        return statusTopic;
    }

    public void setStatusTopic(String statusTopic) {
        this.statusTopic = statusTopic;
    }

    public Long getEventSum() {
        return eventSum;
    }

    public void setEventSum(Long eventSum) {
        this.eventSum = eventSum;
    }

    public Long getPointSum() {
        return pointSum;
    }

    public void setPointSum(Long pointSum) {
        this.pointSum = pointSum;
    }

    public Long getStatusSum() {
        return statusSum;
    }

    public void setStatusSum(Long statusSum) {
        this.statusSum = statusSum;
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

    public boolean isEventEnable() {
        return eventEnable;
    }

    public void setEventEnable(boolean eventEnable) {
        this.eventEnable = eventEnable;
    }

    public boolean isPointEnable() {
        return pointEnable;
    }

    public void setPointEnable(boolean pointEnable) {
        this.pointEnable = pointEnable;
    }

    public boolean isStatusEnable() {
        return statusEnable;
    }

    public void setStatusEnable(boolean statusEnable) {
        this.statusEnable = statusEnable;
    }

    public boolean isBatch() {
        return batch;
    }

    public void setBatch(boolean batch) {
        this.batch = batch;
    }
}
