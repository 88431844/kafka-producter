package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 14:55
 */
public class SendPointMessageDto extends MessageBaseDto{
    private Long pointSum = 1L;
    private String pointTopic = "localevent-point-test";

    @Override
    public String toString() {
        return "SendPointMessageDto{" +
                "pointSum=" + pointSum +
                ", pointTopic='" + pointTopic + '\'' +
                super.toString() +
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
}
