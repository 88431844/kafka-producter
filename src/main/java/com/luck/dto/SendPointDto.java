package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 14:55
 */
public class SendPointDto {
    private Long pointSum = 1L;
    private String pointTopic = "localevent-point-test";
    private Long sleepTime = 500L;
    private String mainDriverId = "2d7206379f3741548c0d17a9999519bf";

    @Override
    public String toString() {
        return "SendPointDto{" +
                "pointSum=" + pointSum +
                ", pointTopic='" + pointTopic + '\'' +
                ", sleepTime=" + sleepTime +
                ", mainDriverId='" + mainDriverId + '\'' +
                '}';
    }

    public Long getPointSum() {
        return pointSum;
    }

    public void setPointSum(Long pointSum) {
        this.pointSum = pointSum;
    }

    public String getPointTopic() {
        return pointTopic;
    }

    public void setPointTopic(String pointTopic) {
        this.pointTopic = pointTopic;
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
