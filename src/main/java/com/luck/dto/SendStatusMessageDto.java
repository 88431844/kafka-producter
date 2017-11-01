package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 14:59
 */
public class SendStatusMessageDto {

    private Long statusSum = 1L;
    private String statusTopic = "localevent-status-test";
    private Long sleepTime = 500L;
    private String mainDriverId = "2d7206379f3741548c0d17a9999519bf";

    @Override
    public String toString() {
        return "SendStatusDto{" +
                "statusSum=" + statusSum +
                ", statusTopic='" + statusTopic + '\'' +
                ", sleepTime=" + sleepTime +
                ", mainDriverId='" + mainDriverId + '\'' +
                '}';
    }

    public Long getStatusSum() {
        return statusSum;
    }

    public void setStatusSum(Long statusSum) {
        this.statusSum = statusSum;
    }

    public String getStatusTopic() {
        return statusTopic;
    }

    public void setStatusTopic(String statusTopic) {
        this.statusTopic = statusTopic;
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
