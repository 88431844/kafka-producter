package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 14:59
 */
public class SendStatusMessageDto extends MessageBaseDto{

    private Long statusSum = 1L;
    private String statusTopic = "localevent-status-test";

    @Override
    public String toString() {
        return "SendStatusMessageDto{" +
                "statusSum=" + statusSum +
                ", statusTopic='" + statusTopic + '\'' +
                super.toString() +
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
}
