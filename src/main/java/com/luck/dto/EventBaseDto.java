package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 16:41
 */
public class EventBaseDto {

    private String QINGQI_COMMAND = "3002";
    private String topic = "jfz_ZHposcan_pkt";
    private String terminalId = "14807431717";

    @Override
    public String toString() {
        return "EventBaseDto{" +
                "QINGQI_COMMAND='" + QINGQI_COMMAND + '\'' +
                ", topic='" + topic + '\'' +
                ", terminalId='" + terminalId + '\'' +
                '}';
    }

    public String getQINGQI_COMMAND() {
        return QINGQI_COMMAND;
    }

    public void setQINGQI_COMMAND(String QINGQI_COMMAND) {
        this.QINGQI_COMMAND = QINGQI_COMMAND;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }
}
